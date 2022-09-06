package com.alkemy.disneyapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long movieId;
    private String title;
    private Date creationDate;
    private Integer rating;
    private String image;
    private List<Long> characters = new ArrayList<>();
    private Long genre;

}