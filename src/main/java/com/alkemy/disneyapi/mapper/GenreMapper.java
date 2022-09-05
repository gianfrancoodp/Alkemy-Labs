package com.alkemy.disneyapi.mapper;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.entities.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreMapper {

    public GenreEntity genreDTO2Entity(GenreDTO genreDTO){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(genreDTO.getName());
        genreEntity.setImage(genreDTO.getImage());
        genreEntity.setMovies(genreDTO.getMovies());
        return genreEntity;
    }

    public GenreDTO genreEntity2DTO(GenreEntity genreEntity){
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreId(genreEntity.getGenreId());
        genreDTO.setName(genreEntity.getName());
        genreDTO.setImage(genreEntity.getImage());
        genreDTO.setMovies(genreEntity.getMovies());
        return genreDTO;
    }

    public GenreEntity updateGenreDTO2Entity(GenreDTO genreDTO, GenreEntity genreEntity){
        GenreEntity genreUpdated = new GenreEntity();
        genreUpdated.setGenreId(genreEntity.getGenreId());
        genreUpdated.setName(genreDTO.getName());
        genreUpdated.setImage(genreDTO.getImage());
        genreUpdated.setMovies(genreEntity.getMovies());
        return genreUpdated;
    }

    public List<GenreDTO> genreEntityList2DTOList(List<GenreEntity> genreList){
        List<GenreDTO> dtoList = new ArrayList<>();
        for (GenreEntity genreEntity : genreList){
            dtoList.add(genreEntity2DTO(genreEntity));
        }
        return dtoList;
    }

}
