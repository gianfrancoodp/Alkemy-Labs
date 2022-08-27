package com.alkemy.disneyapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @Column(nullable = false)
    private String name;

    private String image;

    @OneToMany(mappedBy = "genres", cascade = CascadeType.ALL) //PENDIENTE AQUI
    private Set<MovieEntity> movies;
}
