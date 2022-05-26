package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface SongMapper extends EntityMapper<SongDTO, Song>{

}
