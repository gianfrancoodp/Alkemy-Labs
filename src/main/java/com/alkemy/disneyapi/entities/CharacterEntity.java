package com.alkemy.disneyapi.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
@Getter
@Setter
@SQLDelete(sql = "UPDATE characters SET deleted = true WHERE character_id=?")
@Where(clause = "deleted=false")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id", nullable = false)
    private Long characterId;

    @Column(nullable = false)
    private String name;

    private Integer age;

    private Double weight;

    private String history;

    private String image;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "characters")
    private Set<MovieEntity> movies = new HashSet<>();
}