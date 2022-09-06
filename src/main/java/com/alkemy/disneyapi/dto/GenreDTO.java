package com.alkemy.disneyapi.dto;

import com.alkemy.disneyapi.entities.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class GenreDTO {

    private Long genreId;
    private String name;
    private String image;
    private Set<MovieEntity> movies;

}