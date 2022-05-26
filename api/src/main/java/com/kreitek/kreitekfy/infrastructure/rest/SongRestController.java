package com.kreitek.kreitekfy.infrastructure.rest;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.application.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SongRestController {
    private final SongService songService;

    @Autowired
    public SongRestController(SongService songService) {
        this.songService = songService;
    }

    @CrossOrigin
    @GetMapping(value = "/songs",produces="application/json")
    public ResponseEntity<List<SongDTO>> getAllSongs(){
        List<SongDTO> songDTOS=songService.getAllSongs();
        return new ResponseEntity<>(songDTOS, HttpStatus.OK);

    }
    @CrossOrigin
    @PostMapping(value = "/songs", produces = "application/json", consumes = "application/json")
    public ResponseEntity <SongDTO> insertSong(@RequestBody SongDTO songDTO){
        SongDTO songSaved= this.songService.saveSong(songDTO);
        return new ResponseEntity<>(songSaved,HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping(value = "/songs/{songId}")
    public ResponseEntity<SongDTO>getSongById(@PathVariable Long songId){
        Optional<SongDTO> song= this.songService.getSongById(songId);
        if(song.isPresent()){
            return new ResponseEntity<>(song.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @DeleteMapping (value = "/songs/{songId}")
    public ResponseEntity<?> deleteSong (@PathVariable Long songId){
        this.songService.deleteSong(songId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}