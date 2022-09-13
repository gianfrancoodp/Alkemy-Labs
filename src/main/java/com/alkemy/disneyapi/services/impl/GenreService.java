package com.alkemy.disneyapi.services.impl;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.dto.basic.GenreBasicDTO;
import com.alkemy.disneyapi.dto.filters.GenreFilterDTO;
import com.alkemy.disneyapi.entities.GenreEntity;
import com.alkemy.disneyapi.exception.ParamNotFound;
import com.alkemy.disneyapi.mapper.GenreMapper;
import com.alkemy.disneyapi.repository.GenreRepository;
import com.alkemy.disneyapi.repository.specifications.GenreSpecification;
import com.alkemy.disneyapi.services.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreSpecification genreSpecification;

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
    public GenreDTO getById(Long genreId) {
        GenreEntity genreEntity = genreRepository.getReferenceById(genreId);
        if (Objects.isNull(genreEntity)){
            throw new ParamNotFound("Genre ID is not valid!!");
        }
        GenreDTO genreDTO = genreMapper.genreEntity2DTO(genreEntity);
        return genreDTO;
    }

    @Override
    public List<GenreBasicDTO> getByFilters(String name, String order) {
        GenreFilterDTO genreFilterDTO = new GenreFilterDTO(name, order);
        List<GenreEntity> entities = genreRepository.findAll(genreSpecification.getByFilters(genreFilterDTO));
        List<GenreBasicDTO> basicDTOS = genreMapper.genreEntityList2BasicDTOList(entities);
        return basicDTOS;
    }

    @Override
    public GenreDTO update(Long id, GenreDTO genreDTO) {
        GenreEntity genreEntity = genreRepository.getReferenceById(id);
        if (Objects.isNull(genreEntity)){
            throw new ParamNotFound("Genre ID is not valid!!");
        }
        GenreEntity genreUpdated = genreRepository.save(genreMapper.updateGenreDTO2Entity(genreDTO, genreEntity));
        GenreDTO genreDTOUpdated = genreMapper.genreEntity2DTO(genreUpdated);
        return genreDTOUpdated;
    }

    @Override
    public void delete(Long genreId) {
        if (genreId == null){
            throw new ParamNotFound("Null is not a valid value for the genre ID!!");
        }
        genreRepository.deleteById(genreId);
    }
}