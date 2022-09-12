package com.alkemy.disneyapi.services.impl;

import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;
import com.alkemy.disneyapi.dto.filters.MovieFilterDTO;
import com.alkemy.disneyapi.repository.specifications.MovieSpecification;
import com.alkemy.disneyapi.services.IMovieService;
import com.alkemy.disneyapi.entities.MovieEntity;
import com.alkemy.disneyapi.mapper.MovieMapper;
import com.alkemy.disneyapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieSpecification movieSpecification;

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
    public List<MovieBasicDTO> getByFilters(String title, Long idGenre, String order) {
        MovieFilterDTO movieFilterDTO = new MovieFilterDTO(title, idGenre, order);
        List<MovieEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(movieFilterDTO));
        List<MovieBasicDTO> basicDTOS = movieMapper.movieEntityList2BasicDTOList(entities);
        return basicDTOS;
    }

    @Override
    public MovieDTO getById(Long movieId) {
        MovieEntity movieEntity = movieRepository.getReferenceById(movieId);
        MovieDTO movieDTO = movieMapper.movieEntity2DTO(movieEntity);
        return movieDTO;
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
