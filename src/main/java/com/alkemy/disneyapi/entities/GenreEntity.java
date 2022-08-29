package com.alkemy.disneyapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @Column(nullable = false)
    private String name;

    private String image;

    @OneToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private Set<MovieEntity> movies;
}
