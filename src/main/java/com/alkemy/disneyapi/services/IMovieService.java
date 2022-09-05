package com.alkemy.disneyapi.services;

import com.alkemy.disneyapi.dto.MovieDTO;

import java.util.List;

public interface IMovieService {

    MovieDTO save(MovieDTO genreDTO);
    List<MovieDTO> getAll();
    MovieDTO update(Long id, MovieDTO movieDTO);
    void delete(Long movieId);
}
