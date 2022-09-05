package com.alkemy.disneyapi.services.impl;

import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.entities.MovieEntity;
import com.alkemy.disneyapi.mapper.MovieMapper;
import com.alkemy.disneyapi.repository.MovieRepository;
import com.alkemy.disneyapi.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO save(MovieDTO movieDTO){
        MovieEntity movieEntity = movieMapper.movieDTO2Entity(movieDTO);
        MovieEntity movieEntitySave = movieRepository.save(movieEntity);
        MovieDTO result = movieMapper.movieEntity2DTO(movieEntitySave);
        return result;
    }

    @Override
    public List<MovieDTO> getAll() {
        List<MovieEntity> moviesEntity = movieRepository.findAll();
        List<MovieDTO> moviesDTO = movieMapper.movieEntityList2DTOList(moviesEntity);
        return moviesDTO;
    }

    @Override
    public MovieDTO update(Long id, MovieDTO movieDTO) {
        MovieEntity movieEntity = movieRepository.getReferenceById(id);
        MovieEntity movieUpdated = movieRepository.save(movieMapper.updateMovieDTO2Entity(movieDTO, movieEntity));
        MovieDTO movieDTOUpdated = movieMapper.movieEntity2DTO(movieUpdated);
        return movieDTOUpdated;
    }

    @Override
    public void delete(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
