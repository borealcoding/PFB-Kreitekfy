package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.SongPersistence;
import com.kreitek.kreitekfy.infrastructure.specs.SongSpecification;
import com.kreitek.kreitekfy.infrastructure.specs.shared.SearchCriteriaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class SongPersistenceImpl implements SongPersistence {

    private final SongRepository songRepository;
    @Autowired
    public SongPersistenceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    @Override
    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

    @Override
    public Optional<Song> getSongById(Long songId) {

        return this.songRepository.findById(songId);
    }

    @Override
    public Song saveSong(Song song) {

        return this.songRepository.save(song);
    }

    @Override
    public void deleteSong(Long songId) {
        this.songRepository.deleteById(songId);

    }
    @Override
    public Page<Song> findAll(Pageable pageable,String filter) {
        SongSpecification songSpecification= new SongSpecification(SearchCriteriaHelper.fromFilterString(filter));
        return this.songRepository.findAll(songSpecification,pageable);
    }



    @Override
    public List<Song> getSongsByName(String partialSongName) {
        return this.songRepository.findByNameContainsIgnoreCase(partialSongName);
    }
}
