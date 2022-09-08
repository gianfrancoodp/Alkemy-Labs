package com.alkemy.disneyapi.dto.services;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.dto.basic.GenreBasicDTO;

import java.util.List;

public interface IGenreService {

    GenreBasicDTO save(GenreDTO genreDTO);
    List<GenreDTO> getAll();
    GenreDTO update(Long id, GenreDTO genreDTO);
    void delete(Long id);
}
