

package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;

import java.util.List;
import java.util.Optional;

public interface SongPersistence {
    List<Song>getAllSongs();
    Optional<Song>getSongById(Long songId);
    Song saveSong(Song song);
    void deleteSong(Long songId);
}
