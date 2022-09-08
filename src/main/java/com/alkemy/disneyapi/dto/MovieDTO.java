package com.alkemy.disneyapi.dto;

import com.alkemy.disneyapi.dto.basic.CharacterBasicDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class MovieDTO {

    private Long movieId;
    private String title;
    private Date creationDate;
    private Integer rating;
    private String image;
    private Set<CharacterDTO> characters;
    private Long genre;
}