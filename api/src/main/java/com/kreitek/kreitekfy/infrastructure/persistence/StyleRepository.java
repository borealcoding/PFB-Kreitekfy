package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StyleRepository  extends JpaRepository<Style,Long> {
    List<Style> findByNameContainsIgnoreCase(String partialStyleName);
}
