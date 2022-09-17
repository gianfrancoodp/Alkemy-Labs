package com.alkemy.disneyapi.mapper;

import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;
import com.alkemy.disneyapi.entities.GenreEntity;
import com.alkemy.disneyapi.entities.MovieEntity;
import com.alkemy.disneyapi.exception.ParamNotFound;
import com.alkemy.disneyapi.repository.CharacterRepository;
import com.alkemy.disneyapi.repository.GenreRepository;
import com.alkemy.disneyapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private MovieRepository movieRepository;

    public MovieEntity movieDTO2Entity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setCreationDate(string2LocalDate(movieDTO.getCreationDate()));
        movieEntity.setRating(movieDTO.getRating());
        movieEntity.setImage(movieDTO.getImage());
        movieEntity.setCharacters(characterMapper.characterDTOList2EntityList(movieDTO.getCharacters()));
        if (genreRepository.existsById(movieDTO.getGenre())) {
            GenreEntity genre = genreRepository.getReferenceById(movieDTO.getGenre());
            movieEntity.setGenre(genre);
        } else {
            throw new ParamNotFound("Invalid Genre ID!!");
        }
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity movieEntity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movieEntity.getMovieId());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setCreationDate(movieEntity.getCreationDate().toString());
        movieDTO.setRating(movieEntity.getRating());
        movieDTO.setImage(movieEntity.getImage());
        Set<CharacterDTO> basicCharacters = characterMapper.generateBasicCharacters(movieEntity);
        movieDTO.setCharacters(basicCharacters);
        movieDTO.setGenre(movieEntity.getGenre().getGenreId());
        return movieDTO;
    }

    public MovieBasicDTO movieEntity2BasicDTO(MovieEntity movieEntity) {
        MovieBasicDTO movieBasicDTO = new MovieBasicDTO();
        movieBasicDTO.setMovieId(movieEntity.getMovieId());
        movieBasicDTO.setTitle(movieEntity.getTitle());
        movieBasicDTO.setCreationDate(movieEntity.getCreationDate().toString());
        movieBasicDTO.setImage(movieEntity.getImage());
        return movieBasicDTO;
    }

    public MovieEntity updateMovieDTO2Entity(MovieDTO movieDTO, MovieEntity movieEntity) {
        MovieEntity movieUpdated = new MovieEntity();
        movieUpdated.setMovieId(movieEntity.getMovieId());
        movieUpdated.setTitle(movieDTO.getTitle());
        movieUpdated.setCreationDate(string2LocalDate(movieDTO.getCreationDate()));
        movieUpdated.setRating(movieDTO.getRating());
        movieUpdated.setImage(movieDTO.getImage());
        movieUpdated.setCharacters(movieEntity.getCharacters());
        if (genreRepository.existsById(movieDTO.getGenre())) {
            GenreEntity genre = genreRepository.getReferenceById(movieDTO.getGenre());
            movieUpdated.setGenre(genre);
        } else {
            throw new ParamNotFound("Invalid Genre ID!!");
        }
        return movieUpdated;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> movieEntityList) {
        List<MovieDTO> dtoList = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntityList) {
            dtoList.add(movieEntity2DTO(movieEntity));
        }
        return dtoList;
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList(Set<MovieEntity> movieEntity) {
        List<MovieBasicDTO> dtoBasicList = new ArrayList<>();
        for (MovieEntity entity : movieEntity) {
            dtoBasicList.add(movieEntity2BasicDTO(entity));
        }
        return dtoBasicList;
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList(List<MovieEntity> movieEntity) {
        List<MovieBasicDTO> dtoBasicList = new ArrayList<>();
        for (MovieEntity entity : movieEntity) {
            dtoBasicList.add(movieEntity2BasicDTO(entity));
        }
        return dtoBasicList;
    }

    private LocalDate string2LocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }
}