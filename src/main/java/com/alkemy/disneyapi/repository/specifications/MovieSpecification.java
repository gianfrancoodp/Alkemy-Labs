package com.alkemy.disneyapi.repository.specifications;

import org.springframework.util.StringUtils;
import com.alkemy.disneyapi.dto.filters.MovieFilterDTO;
import com.alkemy.disneyapi.entities.GenreEntity;
import com.alkemy.disneyapi.entities.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSpecification {

    public Specification<MovieEntity> getByFilters(MovieFilterDTO movieFilterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(movieFilterDTO.getTitle())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + movieFilterDTO.getTitle().toLowerCase() + "%"
                        )
                );
            }

            if (movieFilterDTO.getIdGenre() != null) {
                Join<GenreEntity, MovieEntity> join = root.join("genre", JoinType.INNER);
                Expression<Long> genreId = join.get("genreId");
                predicates.add(genreId.in(movieFilterDTO.getIdGenre()));
            }

            // Remove search duplicates
            query.distinct(true);

            // Result order
            String orderByField = "title";
            query.orderBy(
                    movieFilterDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}