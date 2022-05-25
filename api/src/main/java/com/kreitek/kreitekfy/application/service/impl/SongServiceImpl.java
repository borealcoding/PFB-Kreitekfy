package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.application.mapper.SongMapper;
import com.kreitek.kreitekfy.application.service.SongService;
import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.SongPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongPersistence songPersistence;
    private final SongMapper songMapper;

    @Autowired
       public SongServiceImpl(SongPersistence songPersistence, SongMapper songMapper) {
        this.songPersistence = songPersistence;
        this.songMapper = songMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<SongDTO> getAllSongs() {
        List<Song> songs=this.songPersistence.getAllSongs();
        return this.songMapper.toDto(songs);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SongDTO> getSongById(Long songId) {
        return this.songPersistence.getSongById(songId).map(song -> songMapper.toDto(song));
    }

    @Override
    @Transactional
    public SongDTO saveSong(SongDTO songDTO) {
        Song song= this.songPersistence.saveSong(this.songMapper.toEntity(songDTO));
        return this.songMapper.toDto(song);
    }

    @Override
    public void deleteSong(Long songId) {
        this.songPersistence.deleteSong(songId);
    }
}
