package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.application.dto.StyleDTO;
import com.kreitek.kreitekfy.domain.entity.Artist;
import com.kreitek.kreitekfy.domain.entity.Style;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {SongMapper.class})
public interface StyleMapper extends EntityMapper<StyleDTO, Style> {

    default Style fromId(Long id){
        if(id==null)return null;
        Style style=new Style();
        style.setId(id);
        return style;

    }

}
