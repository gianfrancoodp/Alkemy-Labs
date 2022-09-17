package com.alkemy.disneyapi.dto.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreFilterDTO {

    private String name;
    private String order;

    public GenreFilterDTO(String name, String order) {
        this.name = name;
        this.order = order;
    }

    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
