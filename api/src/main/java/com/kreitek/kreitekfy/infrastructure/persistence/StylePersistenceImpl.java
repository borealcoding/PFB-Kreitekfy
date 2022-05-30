package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Style;
import com.kreitek.kreitekfy.domain.persistence.StylePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StylePersistenceImpl implements StylePersistence {

    private final StyleRepository styleRepository;

    @Autowired
    public StylePersistenceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public List<Style> getAllStyle() {
        List<Style> styles=this.styleRepository.findAll();
        return styles;
    }

    @Override
    public Optional<Style> getStyleById(Long styleId) {

        return this.styleRepository.findById(styleId);
    }

    @Override
    public Style saveStyle(Style style) {

        return  this.styleRepository.save(style);
    }

    @Override
    public List<Style> getStylesByName(String partialStyleName) {

        return this.styleRepository.findByNameContainsIgnoreCase(partialStyleName);
    }
}
