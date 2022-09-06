package com.alkemy.disneyapi.mapper;

import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.entities.CharacterEntity;
import com.alkemy.disneyapi.entities.GenreEntity;
import com.alkemy.disneyapi.entities.MovieEntity;
import com.alkemy.disneyapi.repository.CharacterRepository;
import com.alkemy.disneyapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public MovieEntity movieDTO2Entity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setCreationDate(movieDTO.getCreationDate());
        movieEntity.setRating(movieDTO.getRating());
        movieEntity.setImage(movieDTO.getImage());
        List<Long> charactersId = movieDTO.getCharacters();
        Set<CharacterEntity> characters = new HashSet<>();
        for (Long id : charactersId){
            CharacterEntity temp = characterRepository.getReferenceById(id);
            characters.add(temp);
        }
        movieEntity.setCharacters(characters); //TODO: Revisar!!
        GenreEntity genre = genreRepository.getReferenceById(movieDTO.getGenre()); //TODO: Corregir la entrada del GenreID en Movies
        movieEntity.setGenre(genre);
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity movieEntity){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movieEntity.getMovieId());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setCreationDate(movieEntity.getCreationDate());
        movieDTO.setRating(movieEntity.getRating());
        movieDTO.setImage(movieEntity.getImage());
        Set<CharacterEntity> characters = movieEntity.getCharacters();
        List<Long> charactersId = new ArrayList<>();
        for (CharacterEntity character : characters){
            Long temp = character.getCharacterId();
            charactersId.add(temp);
        }
        movieDTO.setCharacters(charactersId); //TODO: Revisar!!
        movieDTO.setGenre(movieEntity.getGenre().getGenreId());
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
