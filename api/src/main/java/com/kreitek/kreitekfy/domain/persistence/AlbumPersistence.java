package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Album;
import com.kreitek.kreitekfy.domain.entity.Song;

import java.util.List;

public interface AlbumPersistence {
    List<Album> getAllAlbums();
    Album saveAlbum(Album album);
    List<Album> getAlbumsByName(String partialAlbumName);
    List<Album>findAll(String filter);


}
