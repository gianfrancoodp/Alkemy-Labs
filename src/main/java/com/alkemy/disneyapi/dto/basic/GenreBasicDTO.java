package com.alkemy.disneyapi.dto.basic;

import com.alkemy.disneyapi.entities.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class GenreBasicDTO {

    private Long genreId;
    private String name;
    private String image;
}
