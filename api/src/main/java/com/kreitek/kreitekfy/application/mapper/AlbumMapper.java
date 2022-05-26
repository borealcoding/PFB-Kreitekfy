package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.domain.entity.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper extends EntityMapper<AlbumDTO, Album>{
}
