package com.alkemy.disneyapi.mapper;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.dto.basic.GenreBasicDTO;
import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;
import com.alkemy.disneyapi.entities.GenreEntity;
import com.alkemy.disneyapi.entities.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class GenreMapper {

    @Autowired
    private MovieMapper movieMapper;

    public GenreEntity genreDTO2Entity(GenreDTO genreDTO){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(genreDTO.getName());
        genreEntity.setImage(genreDTO.getImage());
        return genreEntity;
    }

    public GenreDTO genreEntity2DTO(GenreEntity genreEntity){
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreId(genreEntity.getGenreId());
        genreDTO.setName(genreEntity.getName());
        genreDTO.setImage(genreEntity.getImage());
        List<MovieBasicDTO> basicDTOList = movieMapper.movieEntityList2BasicDTOList(genreEntity.getMovies());
        genreDTO.setMovies(basicDTOList);
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

    public List<GenreBasicDTO> genreEntityList2BasicDTOList(List<GenreEntity> genreList){
        List<GenreBasicDTO> basicDTOList = new ArrayList<>();
        for (GenreEntity genreEntity : genreList){
            basicDTOList.add(genreEntity2BasicDTO(genreEntity));
        }
        return basicDTOList;
    }

    public GenreBasicDTO genreEntity2BasicDTO(GenreEntity genreEntity){
        GenreBasicDTO genreBasicDTO = new GenreBasicDTO();
        genreBasicDTO.setGenreId(genreEntity.getGenreId());
        genreBasicDTO.setName(genreEntity.getName());
        genreBasicDTO.setImage(genreEntity.getImage());
        return genreBasicDTO;
    }

}
