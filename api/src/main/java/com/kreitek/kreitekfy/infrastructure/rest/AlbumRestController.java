package com.kreitek.kreitekfy.infrastructure.rest;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.application.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumRestController {
    private final AlbumService albumService;

    @Autowired
    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @CrossOrigin
    @PostMapping(value = "/albums", produces = "application/json",consumes = "application/json")
    public ResponseEntity<AlbumDTO>insertAlbum(@RequestBody AlbumDTO albumDTO){
        albumDTO=this.albumService.saveAlbum(albumDTO);
        return  new ResponseEntity<>(albumDTO,HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(value = "/albums", produces = "application/json")
    public ResponseEntity<List<AlbumDTO>> getAlbumsPartialName(@RequestParam(name = "partialName", required = false) String partialAlbumName) {
        List<AlbumDTO> albums;

        if (partialAlbumName == null) {
            albums = this.albumService.getAllAlbums();
        } else {
            albums = this.albumService.getAllAlbumsByPartialName(partialAlbumName);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

}
