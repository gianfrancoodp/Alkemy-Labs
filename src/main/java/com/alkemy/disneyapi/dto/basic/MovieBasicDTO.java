package com.alkemy.disneyapi.dto.basic;

import com.alkemy.disneyapi.entities.CharacterEntity;
import com.alkemy.disneyapi.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class MovieBasicDTO {

    private Long movieId;
    private String title;
    private Date creationDate;
    private String image;

}
