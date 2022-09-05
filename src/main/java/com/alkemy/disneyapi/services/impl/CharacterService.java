package com.alkemy.disneyapi.services.impl;

import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.entities.CharacterEntity;
import com.alkemy.disneyapi.mapper.CharacterMapper;
import com.alkemy.disneyapi.repository.CharacterRepository;
import com.alkemy.disneyapi.services.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO save(CharacterDTO characterDTO){
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
    public CharacterDTO update(Long id, CharacterDTO characterDTO) {
        CharacterEntity characterEntity = characterRepository.getReferenceById(id);
        CharacterEntity characterUpdated = characterRepository.save(characterMapper.updateCharacterDTO2Entity(characterDTO, characterEntity));
        CharacterDTO characterDTOUpdated = characterMapper.characterEntity2DTO(characterUpdated);
        return characterDTOUpdated;
    }

    @Override
    public void delete(Long characterId) {
        characterRepository.deleteById(characterId);
    }

}
