package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring", uses = ArtistMapper.class)
public interface SongMapper extends EntityMapper<SongDTO, Song>{

    @Override
    @Mapping(source = "artistId", target = "artist")
    Song toEntity(SongDTO dto);

    @Override
    @Mapping(source = "artist.id", target = "artistId")
    @Mapping(source = "artist.name", target = "artistName")
    SongDTO toDto(Song entity);
}
