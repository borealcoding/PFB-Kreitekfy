package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SongService {

    List<SongDTO>getAllSongs();
    Optional<SongDTO> getSongById(Long songId);
    SongDTO saveSong(SongDTO songDTO);
    void deleteSong(Long songId);
    Page<SongDTO> getSongPaged(Pageable pageable);

}
