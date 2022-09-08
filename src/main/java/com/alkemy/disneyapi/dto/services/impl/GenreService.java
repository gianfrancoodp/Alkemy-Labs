package com.alkemy.disneyapi.dto.services.impl;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.dto.basic.GenreBasicDTO;
import com.alkemy.disneyapi.entities.GenreEntity;
import com.alkemy.disneyapi.mapper.GenreMapper;
import com.alkemy.disneyapi.repository.GenreRepository;
import com.alkemy.disneyapi.dto.services.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreBasicDTO save(GenreDTO genreDTO) {
        GenreEntity genreEntity = genreRepository.save(genreMapper.genreDTO2Entity(genreDTO));
        GenreBasicDTO result = genreMapper.genreEntity2BasicDTO(genreEntity);
        return result;
    }

    @Override
    public List<GenreDTO> getAll() {
        List<GenreEntity> genreEntity = genreRepository.findAll();
        List<GenreDTO> genreDTO = genreMapper.genreEntityList2DTOList(genreEntity);
        return genreDTO;
    }

    @Override
    public GenreDTO update(Long id, GenreDTO genreDTO) {
        GenreEntity genreEntity = genreRepository.getReferenceById(id);
        GenreEntity genreUpdated = genreRepository.save(genreMapper.updateGenreDTO2Entity(genreDTO, genreEntity));
        GenreDTO genreDTOUpdated = genreMapper.genreEntity2DTO(genreUpdated);
        return genreDTOUpdated;
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}