package com.alkemy.disneyapi.dto;

import com.alkemy.disneyapi.entities.CharacterEntity;
import com.alkemy.disneyapi.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class MovieDTO {

    private Long movieId;
    private String title;
    private Date creationDate;
    private Integer rating;
    private String image;
    private Set<CharacterEntity> characters;
    private GenreEntity genre;

}