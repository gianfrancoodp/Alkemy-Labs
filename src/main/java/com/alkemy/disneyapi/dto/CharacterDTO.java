package com.alkemy.disneyapi.dto;

import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterDTO {

    private Long characterId;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    private String image;
    private List<MovieBasicDTO> movies;
}
