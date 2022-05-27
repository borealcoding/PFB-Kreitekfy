package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Artist;

import java.util.List;

public interface ArtistPersistence {
    List<Artist> getAllArtist();
    Artist saveArtist(Artist artist);
}
