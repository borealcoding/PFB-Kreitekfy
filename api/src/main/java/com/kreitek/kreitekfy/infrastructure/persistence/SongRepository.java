package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SongRepository extends JpaRepository<Song,Long>, JpaSpecificationExecutor<Song> {
}
