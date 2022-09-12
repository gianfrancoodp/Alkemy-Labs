package com.alkemy.disneyapi.services;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.dto.basic.GenreBasicDTO;

import java.util.List;

public interface IGenreService {

    GenreBasicDTO save(GenreDTO genreDTO);
    List<GenreDTO> getAll();
    GenreDTO getById(Long genreId);
    GenreDTO update(Long id, GenreDTO genreDTO);
    void delete(Long id);
}
