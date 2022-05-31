package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Album;
import com.kreitek.kreitekfy.domain.persistence.AlbumPersistence;
import com.kreitek.kreitekfy.infrastructure.specs.AlbumSpecification;
import com.kreitek.kreitekfy.infrastructure.specs.shared.SearchCriteriaHelper;
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

    @Override
    public List<Album> getAlbumsByName(String partialAlbumName) {
        return this.albumRepository.findByNameContainsIgnoreCase(partialAlbumName);
    }

    @Override
    public List<Album> findAll(String filter) {
        AlbumSpecification albumSpecification=new AlbumSpecification(SearchCriteriaHelper.fromFilterString(filter));
        return this.albumRepository.findAll(albumSpecification);
    }

}
