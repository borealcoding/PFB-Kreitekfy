package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {
}
