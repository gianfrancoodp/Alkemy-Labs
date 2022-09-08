package com.alkemy.disneyapi.dto.basic;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieBasicDTO {

    private Long movieId;
    private String title;
    private Date creationDate;
    private String image;

}
