package com.alkemy.disneyapi.services.impl;

import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.dto.basic.CharacterBasicDTO;
import com.alkemy.disneyapi.dto.filters.CharacterFilterDTO;
import com.alkemy.disneyapi.entities.CharacterEntity;
import com.alkemy.disneyapi.exception.ParamNotFound;
import com.alkemy.disneyapi.mapper.CharacterMapper;
import com.alkemy.disneyapi.repository.CharacterRepository;
import com.alkemy.disneyapi.repository.specifications.CharacterSpecification;
import com.alkemy.disneyapi.services.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterSpecification characterSpecification;

    public CharacterDTO save(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(characterDTO);
        CharacterEntity characterEntitySave = characterRepository.save(characterEntity);
        CharacterDTO result = characterMapper.characterEntity2DTO(characterEntitySave);
        return result;
    }

    @Override
    public List<CharacterDTO> getAll() {
        List<CharacterEntity> characterEntity = characterRepository.findAll();
        List<CharacterDTO> characterDTO = characterMapper.characterEntityList2DTOList(characterEntity);
        return characterDTO;
    }

    @Override
    public List<CharacterBasicDTO> getByFilters(String name, Integer age, List<Long> movies, String order) {
        CharacterFilterDTO characterFilterDTO = new CharacterFilterDTO(name, age, movies, order);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(characterFilterDTO));
        List<CharacterBasicDTO> basicDTOS = characterMapper.characterEntityList2BasicDTOList(entities);
        return basicDTOS;
    }

    @Override
    public CharacterDTO getById(Long characterId) {
        CharacterEntity characterEntity = characterRepository.getReferenceById(characterId);
        if (Objects.isNull(characterEntity)) {
            throw new ParamNotFound("Character ID is not valid!!");
        }
        CharacterDTO characterDTO = characterMapper.characterEntity2DTO(characterEntity);
        return characterDTO;
    }

    @Override
    public CharacterDTO update(Long id, CharacterDTO characterDTO) {
        CharacterEntity characterEntity = characterRepository.getReferenceById(id);
        if (Objects.isNull(characterEntity)) {
            throw new ParamNotFound("Character ID is not valid!!");
        }
        CharacterEntity characterUpdated = characterRepository.save(characterMapper.updateCharacterDTO2Entity(characterDTO, characterEntity));
        CharacterDTO characterDTOUpdated = characterMapper.characterEntity2DTO(characterUpdated);
        return characterDTOUpdated;
    }

    @Override
    public void delete(Long characterId) {
        if (characterId == null) {
            throw new ParamNotFound("Null is not a valid value for the character ID!!");
        }
        characterRepository.deleteById(characterId);
    }

}
