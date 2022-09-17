package com.alkemy.disneyapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MovieDTO {

    private Long movieId;
    private String title;
    private String creationDate;
    private Integer rating;
    private String image;
    private Set<CharacterDTO> characters;
    private Long genre;
}