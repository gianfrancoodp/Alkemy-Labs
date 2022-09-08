package com.alkemy.disneyapi.services;

import com.alkemy.disneyapi.dto.MovieDTO;

import java.util.List;
import java.util.Set;

public interface IMovieService {

    MovieDTO save(MovieDTO genreDTO);
    Set<MovieDTO> getAll();
    MovieDTO update(Long id, MovieDTO movieDTO);
    void delete(Long movieId);
}
