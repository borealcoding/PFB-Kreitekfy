package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring", uses = {ArtistMapper.class, AlbumMapper.class,StyleMapper.class})
public interface SongMapper extends EntityMapper<SongDTO, Song>{

    @Override
    @Mapping(source = "artistId", target = "artist")
    @Mapping(source = "albumId",target= "album")
    @Mapping(source = "styleId",target = "style")
    Song toEntity(SongDTO songDTO);

    @Override
    @Mapping(source = "artist.id", target = "artistId")
    @Mapping(source = "artist.name", target = "artistName")
    @Mapping(source = "album.id",target = "albumId")
    @Mapping(source = "album.name",target = "albumName")
    @Mapping(source = "album.image",target = "image")
    @Mapping(source = "style.id", target = "styleId")
    @Mapping(source = "style.name", target = "styleName")
    SongDTO toDto(Song entity);
}
