package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.application.dto.AlbumSimpleDTO;
import com.kreitek.kreitekfy.domain.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {SongMapper.class,ArtistMapper.class})
public interface AlbumMapper extends EntityMapper<AlbumDTO, Album>{

        @Override
        @Mapping(source = "artistId", target = "artist")
        Album toEntity (AlbumDTO albumDTO);

        @Override
        @Mapping(source = "artist.id", target = "artistId")
        @Mapping(source = "artist.name", target = "artistName")
        //@InheritInverseConfiguration
        AlbumDTO toDto(Album album);

        default Album fromId(Long id){
            if (id==null)return null;
            Album album= new Album();
            album.setId(id);
            return album;
        }

}
