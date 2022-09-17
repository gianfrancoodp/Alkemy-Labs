package com.alkemy.disneyapi.dto.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFilterDTO {

    private String title;
    private Long idGenre;
    private String order;

    public MovieFilterDTO(String title, Long idGenre, String order) {
        this.title = title;
        this.idGenre = idGenre;
        this.order = order;
    }

    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
