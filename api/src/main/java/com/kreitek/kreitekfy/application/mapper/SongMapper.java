package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring", uses={AlbumMapper.class})
public interface SongMapper extends EntityMapper<SongDTO, Song>{
    @Override
    @Mapping(source = "albumId",target= "album")
    Song toEntity(SongDTO songDTO);

    @Override
    @Mapping(source = "album.id",target = "albumId")
    @Mapping(source = "album.name",target = "albumName")
    SongDTO toDto(Song entity);

}
