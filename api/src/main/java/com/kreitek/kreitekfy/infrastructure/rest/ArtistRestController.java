package com.kreitek.kreitekfy.infrastructure.rest;


import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.application.dto.StyleDTO;
import com.kreitek.kreitekfy.application.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistRestController {
    private final ArtistService artistService;

    @Autowired
    public ArtistRestController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @CrossOrigin
    @PostMapping(value = "/artists", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ArtistDTO> insertArtist(@RequestBody ArtistDTO artistDTO) {
        ArtistDTO artistSaved = this.artistService.saveArtist(artistDTO);
        return new ResponseEntity<>(artistSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(value = "/artists", produces = "application/json")
    ResponseEntity<List<ArtistDTO>> getStylesPartialName(@RequestParam(name = "partialName", required = false) String partialArtistName) {
        List<ArtistDTO> artist;

        if (partialArtistName == null) {
            artist = artistService.getAllArtist();
        } else {
            artist = this.artistService.getAllArtistByPartialName(partialArtistName);
        }
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }
}
