package com.alkemy.disneyapi.dto.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieBasicDTO {

    private Long movieId;
    private String title;
    private String creationDate;
    private String image;

}
