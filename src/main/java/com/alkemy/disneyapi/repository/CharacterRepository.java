package com.alkemy.disneyapi.repository;

import com.alkemy.disneyapi.entities.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity,Long> {

    List<CharacterEntity> findAll(Specification<CharacterEntity> spec);

}
