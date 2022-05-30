package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.StyleDTO;

import java.util.List;
import java.util.Optional;

public interface StyleService {
    List<StyleDTO>getAllStyles();
    StyleDTO saveStyle(StyleDTO styleDTO);
    Optional<StyleDTO>getStyleById(Long styleId);

    List<StyleDTO> getAllStylesByPartialName(String partialStyleName);
}
