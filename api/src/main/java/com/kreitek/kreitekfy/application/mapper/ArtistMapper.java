package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.domain.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SongMapper.class)
public interface ArtistMapper extends EntityMapper<ArtistDTO, Artist> {

    @Override
    @Mapping(target = "songs", ignore = true)
    Artist toEntity(ArtistDTO dto);
    ArtistDTO toDto(Artist artist);

    default Artist fromId(Long id) {
        if (id == null) return null;

        Artist artist = new Artist();
        artist.setId(id);
        return artist;
    }
}
