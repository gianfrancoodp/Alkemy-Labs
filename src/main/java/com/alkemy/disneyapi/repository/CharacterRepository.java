package com.alkemy.disneyapi.repository;

import com.alkemy.disneyapi.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity,Long> {

}
