package com.kreitek.kreitekfy.infrastructure.rest;


import com.kreitek.kreitekfy.application.dto.ArtistDTO;
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
    @GetMapping(value = "/artists", produces = "application/json")
    public ResponseEntity<List<ArtistDTO>> getAllArtist() {
        List<ArtistDTO> artistDTOS = artistService.getAllArtist();
        return new ResponseEntity<>(artistDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/artists", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ArtistDTO> insertArtist(@RequestBody ArtistDTO artistDTO) {
        ArtistDTO artistSaved = this.artistService.saveArtist(artistDTO);
        return new ResponseEntity<>(artistSaved, HttpStatus.CREATED);
    }
}
