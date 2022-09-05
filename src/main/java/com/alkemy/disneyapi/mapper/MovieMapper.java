package com.alkemy.disneyapi.mapper;

import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.entities.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public MovieEntity movieDTO2Entity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setCreationDate(movieDTO.getCreationDate());
        movieEntity.setRating(movieDTO.getRating());
        movieEntity.setImage(movieDTO.getImage());
        //movieEntity.setCharacters(movieDTO.getCharacters()); //TODO: Revisar!!!
        //GenreEntity genre = genreRepository.findById(movieDTO.getGenre()); //TODO: Corregir la entrada del GenreID en Movies
        //movieEntity.setGenre(genre);
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity movieEntity){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movieEntity.getMovieId());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setCreationDate(movieEntity.getCreationDate());
        movieDTO.setRating(movieEntity.getRating());
        movieDTO.setImage(movieEntity.getImage());
        movieDTO.setCharacters(movieEntity.getCharacters());
        movieDTO.setGenre(movieEntity.getGenre());
        return movieDTO;
    }

    public MovieEntity updateMovieDTO2Entity(MovieDTO movieDTO, MovieEntity movieEntity){
        MovieEntity movieUpdated = new MovieEntity();
        movieUpdated.setMovieId(movieEntity.getMovieId());
        movieUpdated.setTitle(movieDTO.getTitle());
        movieUpdated.setCreationDate(movieDTO.getCreationDate());
        movieUpdated.setRating(movieDTO.getRating());
        movieUpdated.setImage(movieDTO.getImage());
        movieUpdated.setCharacters(movieEntity.getCharacters());
        movieUpdated.setGenre(movieEntity.getGenre());
        return movieUpdated;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> movieList){
        List<MovieDTO> dtoList = new ArrayList<>();
        for (MovieEntity movieEntity : movieList){
            dtoList.add(movieEntity2DTO(movieEntity));
        }
        return dtoList;
    }

}
