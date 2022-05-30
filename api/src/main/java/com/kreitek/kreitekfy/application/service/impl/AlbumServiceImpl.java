package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.application.mapper.AlbumMapper;
import com.kreitek.kreitekfy.application.service.AlbumService;
import com.kreitek.kreitekfy.domain.entity.Album;
import com.kreitek.kreitekfy.domain.persistence.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumPersistence albumPersistence;
    private final AlbumMapper albumMapper;

    @Autowired
    public AlbumServiceImpl(AlbumPersistence albumPersistence, AlbumMapper albumMapper) {
        this.albumPersistence = albumPersistence;
        this.albumMapper = albumMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<AlbumDTO> getAllAlbums() {
        List<Album> albums= this.albumPersistence.getAllAlbums();
        return albumMapper.toDto(albums);

    }

    @Override
    @Transactional
    public AlbumDTO saveAlbum(AlbumDTO albumDTO) {
        Album album= this.albumPersistence.saveAlbum(this.albumMapper.toEntity(albumDTO));
        return this.albumMapper.toDto(album);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AlbumDTO> getAllAlbumsByPartialName(String partialAlbumName) {
        List<Album> albums = this.albumPersistence.getAlbumsByName(partialAlbumName);
        return albumMapper.toDto(albums);
    }
}
