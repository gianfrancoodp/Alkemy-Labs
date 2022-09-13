package com.alkemy.disneyapi.repository;

import com.alkemy.disneyapi.entities.GenreEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity,Long> {

    List<GenreEntity> findAll(Specification<GenreEntity> spec);

}
