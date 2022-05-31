package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Album;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album,Long>, JpaSpecificationExecutor<Album> {
    List<Album> findByNameContainsIgnoreCase(String partialAlbumName);
}
