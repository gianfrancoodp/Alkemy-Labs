package com.alkemy.disneyapi.dto;

import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreDTO {

    private Long genreId;
    private String name;
    private String image;
    private List<MovieBasicDTO> movies;

}
