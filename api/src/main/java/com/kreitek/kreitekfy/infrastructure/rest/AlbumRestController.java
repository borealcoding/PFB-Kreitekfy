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
    @GetMapping(value = "/albums", produces = "application/json")
    public ResponseEntity<List<AlbumDTO>> getAllAlbum(){
        List<AlbumDTO> albumDTOS= albumService.getAllAlbums();
        return new ResponseEntity<>(albumDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/albums", produces = "application/json",consumes = "application/json")
    public ResponseEntity<AlbumDTO>insertAlbum(@RequestBody AlbumDTO albumDTO){
        albumDTO=this.albumService.saveAlbum(albumDTO);
        return  new ResponseEntity<>(albumDTO,HttpStatus.CREATED);
    }

}
