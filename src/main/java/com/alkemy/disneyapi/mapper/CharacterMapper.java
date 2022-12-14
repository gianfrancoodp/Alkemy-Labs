package com.alkemy.disneyapi.mapper;

import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.dto.basic.CharacterBasicDTO;
import com.alkemy.disneyapi.entities.CharacterEntity;
import com.alkemy.disneyapi.entities.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CharacterMapper {

    @Autowired
    private MovieMapper movieMapper;

    public CharacterEntity characterDTO2Entity(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(characterDTO.getName());
        characterEntity.setAge(characterDTO.getAge());
        characterEntity.setWeight(characterDTO.getWeight());
        characterEntity.setHistory(characterDTO.getHistory());
        characterEntity.setImage(characterDTO.getImage());
        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity characterEntity) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setCharacterId(characterEntity.getCharacterId());
        characterDTO.setName(characterEntity.getName());
        characterDTO.setAge(characterEntity.getAge());
        characterDTO.setWeight(characterEntity.getWeight());
        characterDTO.setHistory(characterEntity.getHistory());
        characterDTO.setImage(characterEntity.getImage());
        characterDTO.setMovies(movieMapper.movieEntityList2BasicDTOList(characterEntity.getMovies()));
        return characterDTO;
    }

    public CharacterBasicDTO characterEntity2BasicDTO(CharacterEntity characterEntity) {
        CharacterBasicDTO characterBasicDTO = new CharacterBasicDTO();
        characterBasicDTO.setCharacterId(characterEntity.getCharacterId());
        characterBasicDTO.setName(characterEntity.getName());
        characterBasicDTO.setImage(characterEntity.getImage());
        return characterBasicDTO;
    }

    public CharacterEntity updateCharacterDTO2Entity(CharacterDTO characterDTO, CharacterEntity characterEntity) {
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

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characterEntityList) {
        List<CharacterDTO> dtoList = new ArrayList<>();
        for (CharacterEntity characterEntity : characterEntityList) {
            dtoList.add(characterEntity2DTO(characterEntity));
        }
        return dtoList;
    }

    public Set<CharacterEntity> characterDTOList2EntityList(Set<CharacterDTO> characterDTOList) {
        Set<CharacterEntity> entityList = new HashSet<>();
        for (CharacterDTO characterDTO : characterDTOList) {
            entityList.add(characterDTO2Entity(characterDTO));
        }
        return entityList;
    }

    public List<CharacterBasicDTO> characterEntityList2BasicDTOList(List<CharacterEntity> characterEntityList) {
        List<CharacterBasicDTO> basicCharacterList = new ArrayList<>();
        for (CharacterEntity characterEntity : characterEntityList) {
            basicCharacterList.add(characterEntity2BasicDTO(characterEntity));
        }
        return basicCharacterList;
    }

    public Set<CharacterDTO> generateBasicCharacters(MovieEntity movieEntity) {
        Set<CharacterDTO> basicCharacters = new HashSet<>();
        Set<CharacterEntity> charactersEntity = movieEntity.getCharacters();
        for (CharacterEntity character : charactersEntity) {
            CharacterDTO characterTemp = new CharacterDTO();
            characterTemp.setCharacterId(character.getCharacterId());
            characterTemp.setName(character.getName());
            characterTemp.setAge(character.getAge());
            characterTemp.setWeight(character.getWeight());
            characterTemp.setImage(character.getImage());
            characterTemp.setHistory(character.getHistory());
            basicCharacters.add(characterTemp);
        }
        return basicCharacters;
    }

}
