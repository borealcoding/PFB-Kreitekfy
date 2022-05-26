package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.SongDTO;

import java.util.List;
import java.util.Optional;

public interface SongService {

    List<SongDTO>getAllSongs();
    Optional<SongDTO> getSongById(Long songId);
    SongDTO saveSong(SongDTO songDTO);

    void deleteSong(Long songId);

}
