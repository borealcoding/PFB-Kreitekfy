package com.kreitek.kreitekfy.domain.persistence;



import com.kreitek.kreitekfy.domain.entity.Style;

import java.util.List;
import java.util.Optional;

public interface StylePersistence {
    List<Style> getAllStyle();
    Optional<Style> getStyleById(Long styleId);
    Style saveStyle(Style style);

    List<Style> getCategoriesByName(String partialStyleName);
}
