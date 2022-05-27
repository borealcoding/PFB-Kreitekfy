package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.StyleDTO;
import com.kreitek.kreitekfy.application.mapper.StyleMapper;
import com.kreitek.kreitekfy.application.service.StyleService;
import com.kreitek.kreitekfy.domain.entity.Style;
import com.kreitek.kreitekfy.domain.persistence.StylePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class StyleServiceImpl implements StyleService {

    private final StylePersistence stylePersistence;
    private final StyleMapper styleMapper;

    @Autowired
    public StyleServiceImpl(StylePersistence stylePersistence, StyleMapper styleMapper) {
        this.stylePersistence = stylePersistence;
        this.styleMapper = styleMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<StyleDTO> getAllStyles() {
        List<Style> styles= this.stylePersistence.getAllStyle();
        return styleMapper.toDto(styles);

    }

    @Override
    @Transactional
    public StyleDTO saveStyle(StyleDTO styleDTO) {
        Style style=this.stylePersistence.saveStyle(this.styleMapper.toEntity(styleDTO));
        return this.styleMapper.toDto(style);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StyleDTO> getStyleById(Long styleId) {
          return  this.stylePersistence.getStyleById(styleId).map(styleMapper::toDto);
    }
}
