package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Album;
import com.kreitek.kreitekfy.domain.persistence.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumPersistenceImpl implements AlbumPersistence {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumPersistenceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @Override
    public List<Album> getAllAlbums() {
       List<Album> albums = this.albumRepository.findAll();
       return albums;
    }

    @Override
    public Album saveAlbum(Album album) {
        return this.albumRepository.save(album);
    }
}