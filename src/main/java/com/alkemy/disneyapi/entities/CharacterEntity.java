package com.alkemy.disneyapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "characters")
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

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private Set<MovieEntity> movies = new HashSet<>();

}
