package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.domain.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AlbumMapper.class, SongMapper.class,StyleMapper.class})
public interface ArtistMapper extends EntityMapper<ArtistDTO, Artist> {

    @Override
    @Mapping(target = "album", ignore = true)
    @Mapping(target = "songs", ignore = true)
    @Mapping(source = "styleId",target = "style")
    Artist toEntity(ArtistDTO dto);

    @Override
    @Mapping(source = "style.id", target = "styleId")
    @Mapping(source = "style.name", target = "styleName")
    ArtistDTO toDto(Artist artist);

    default Artist fromId(Long id) {
        if (id == null) return null;

        Artist artist = new Artist();
        artist.setId(id);
        return artist;
    }
}
