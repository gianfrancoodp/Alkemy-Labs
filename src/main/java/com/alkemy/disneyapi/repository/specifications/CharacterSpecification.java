package com.alkemy.disneyapi.repository.specifications;

import com.alkemy.disneyapi.dto.filters.CharacterFilterDTO;
import com.alkemy.disneyapi.entities.CharacterEntity;
import com.alkemy.disneyapi.entities.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterSpecification {

    public Specification<CharacterEntity> getByFilters(CharacterFilterDTO characterFilterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(characterFilterDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + characterFilterDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            if (characterFilterDTO.getAge() != null) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("age"),
                                characterFilterDTO.getAge()
                        )
                );
            }

            if (!CollectionUtils.isEmpty(characterFilterDTO.getMovies())) {
                Join<MovieEntity, CharacterEntity> join = root.join("movies", JoinType.INNER);
                Expression<Long> movieId = join.get("movieId");
                predicates.add(movieId.in(characterFilterDTO.getMovies()));
            }

            // Remove search duplicates
            query.distinct(true);

            // Result order
            String orderByField = "name";
            query.orderBy(
                    characterFilterDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
