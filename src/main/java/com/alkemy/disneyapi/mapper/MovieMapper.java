package com.alkemy.disneyapi.mapper;

import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;
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
    private GenreMapper genreMapper;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterMapper characterMapper;

    public MovieEntity movieDTO2Entity(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setCreationDate(movieDTO.getCreationDate());
        movieEntity.setRating(movieDTO.getRating());
        movieEntity.setImage(movieDTO.getImage());
        movieEntity.setCharacters(characterMapper.characterDTOList2EntityList(movieDTO.getCharacters()));
        if (genreRepository.existsById(movieDTO.getGenre())) {
            movieEntity.setGenre(genreRepository.getReferenceById(movieDTO.getGenre()));
        }
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity movieEntity){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movieEntity.getMovieId());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setCreationDate(movieEntity.getCreationDate());
        movieDTO.setRating(movieEntity.getRating());
        movieDTO.setImage(movieEntity.getImage());
        //movieDTO.setCharacters(characterMapper.characterEntityList2DTOList(movieEntity.getCharacters()));
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
        //movieUpdated.setGenre(genreMapper.genreDTO2Entity(movieDTO.getGenre()));
        return movieUpdated;
    }

    public Set<MovieDTO> movieEntityList2DTOList(Set<MovieEntity> movieEntityList){ // TODO: Se cambió de "List" a "Set", por ende hay que revisar que funcione bien!!
        Set<MovieDTO> dtoList = new HashSet<>();
        for (MovieEntity movieEntity : movieEntityList){
            dtoList.add(movieEntity2DTO(movieEntity));
        }
        return dtoList;
    }

    public List<MovieEntity> movieDTOList2EntityList(List<MovieDTO> movieDTOList){
        List<MovieEntity> entityList = new ArrayList<>();
        for (MovieDTO movieDTO : movieDTOList){
            entityList.add(movieDTO2Entity(movieDTO));
        }
        return entityList;
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList (Set<MovieEntity> movieEntity){
        List<MovieBasicDTO> dtoBasicList = new ArrayList<>();
        for (MovieEntity entity :  movieEntity){
            dtoBasicList.add(movieEntity2BasicDTO(entity));
        }
        return dtoBasicList;
    }

    public MovieBasicDTO movieEntity2BasicDTO (MovieEntity movieEntity){
        MovieBasicDTO movieBasicDTO = new MovieBasicDTO();
        movieBasicDTO.setMovieId(movieEntity.getMovieId());
        movieBasicDTO.setTitle(movieEntity.getTitle());
        movieBasicDTO.setCreationDate(movieEntity.getCreationDate());
        movieBasicDTO.setImage(movieEntity.getImage());
        return movieBasicDTO;
    }

}
