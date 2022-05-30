package com.kreitek.kreitekfy.infrastructure.specs;

import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.infrastructure.specs.shared.EntitySpecification;
import com.kreitek.kreitekfy.infrastructure.specs.shared.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SongSpecification extends EntitySpecification <Song> implements Specification<Song> {
    public SongSpecification(List<SearchCriteria> criteria){
        this.criteria=criteria;
    }
}
