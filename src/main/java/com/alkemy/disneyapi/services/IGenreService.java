package com.alkemy.disneyapi.services;

import com.alkemy.disneyapi.dto.GenreDTO;

import java.util.List;

public interface IGenreService {

    GenreDTO save(GenreDTO genreDTO);
    List<GenreDTO> getAll();
    GenreDTO update(Long id, GenreDTO genreDTO);
    void delete(Long id);
}
