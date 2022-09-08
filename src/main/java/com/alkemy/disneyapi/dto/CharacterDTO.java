package com.alkemy.disneyapi.dto;

import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;
import com.alkemy.disneyapi.entities.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
