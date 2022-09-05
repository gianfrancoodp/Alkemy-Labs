package com.alkemy.disneyapi.mapper;

import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.entities.CharacterEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    public CharacterEntity characterDTO2Entity(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(characterDTO.getName());
        characterEntity.setAge(characterDTO.getAge());
        characterEntity.setWeight(characterDTO.getWeight());
        characterEntity.setHistory(characterDTO.getHistory());
        characterEntity.setImage(characterDTO.getImage());
        //characterEntity.setMovies(characterDTO.getMovies()); //TODO: Revisar!!!
        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity characterEntity){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setCharacterId(characterEntity.getCharacterId());
        characterDTO.setName(characterEntity.getName());
        characterDTO.setAge(characterEntity.getAge());
        characterDTO.setWeight(characterEntity.getWeight());
        characterDTO.setHistory(characterEntity.getHistory());
        characterDTO.setImage(characterEntity.getImage());
        characterDTO.setMovies(characterEntity.getMovies());
        return characterDTO;
    }

    public CharacterEntity updateCharacterDTO2Entity(CharacterDTO characterDTO, CharacterEntity characterEntity){
        CharacterEntity characterUpdated = new CharacterEntity();
        characterUpdated.setCharacterId(characterEntity.getCharacterId());
        characterUpdated.setName(characterDTO.getName());
        characterUpdated.setAge(characterDTO.getAge());
        characterUpdated.setWeight(characterDTO.getWeight());
        characterUpdated.setHistory(characterDTO.getHistory());
        characterUpdated.setImage(characterDTO.getImage());
        characterUpdated.setMovies(characterEntity.getMovies());
        return characterUpdated;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characterList){
        List<CharacterDTO> dtoList = new ArrayList<>();
        for (CharacterEntity characterEntity : characterList){
            dtoList.add(characterEntity2DTO(characterEntity));
        }
        return dtoList;
    }
}
