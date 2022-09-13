package com.alkemy.disneyapi.services;

import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;

import java.util.List;

public interface IMovieService {

    MovieDTO save(MovieDTO genreDTO);

    MovieDTO addCharacterToMovie(Long movieId, Long characterId);

    List<MovieDTO> getAll();

    MovieDTO getById(Long movieId);

    List<MovieBasicDTO> getByFilters(String title, Long idGenre, String order);

    MovieDTO update(Long id, MovieDTO movieDTO);

    void delete(Long movieId);

    MovieDTO deleteCharacterFromMovie(Long movieId, Long characterId);
}
