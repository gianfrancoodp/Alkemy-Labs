package com.alkemy.disneyapi.repository.specifications;

import com.alkemy.disneyapi.dto.filters.GenreFilterDTO;
import com.alkemy.disneyapi.entities.GenreEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class GenreSpecification {

    public Specification<GenreEntity> getByFilters(GenreFilterDTO genreFilterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(genreFilterDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + genreFilterDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            // Remove search duplicates
            query.distinct(true);

            // Result order
            String orderByField = "name";
            query.orderBy(
                    genreFilterDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}