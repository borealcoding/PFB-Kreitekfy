package com.kreitek.kreitekfy.application.service.impl;


import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.application.mapper.ArtistMapper;
import com.kreitek.kreitekfy.application.service.ArtistService;
import com.kreitek.kreitekfy.domain.entity.Artist;
import com.kreitek.kreitekfy.domain.persistence.ArtistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistPersistence artistPersistence;
    private final ArtistMapper artistMapper;

    @Autowired
    public ArtistServiceImpl(ArtistPersistence artistPersistence, ArtistMapper artistMapper) {
        this.artistPersistence = artistPersistence;
        this.artistMapper = artistMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArtistDTO> getAllArtist() {
        List<Artist> artists = this.artistPersistence.getAllArtist();
        return this.artistMapper.toDto(artists);
    }

    @Override
    @Transactional
    public ArtistDTO saveArtist(ArtistDTO artistDTO) {
        Artist artist = this.artistPersistence.saveArtist(this.artistMapper.toEntity(artistDTO));
        return this.artistMapper.toDto(artist);
    }
}
