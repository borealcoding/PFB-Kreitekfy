package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository  extends JpaRepository<Style,Long> {
}
