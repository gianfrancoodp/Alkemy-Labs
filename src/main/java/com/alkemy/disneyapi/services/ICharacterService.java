package com.alkemy.disneyapi.services;

import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.dto.basic.CharacterSlimDTO;

import java.util.List;

public interface ICharacterService {

    CharacterDTO save(CharacterDTO characterDTO);

    List<CharacterDTO> getAll();

    List<CharacterSlimDTO> getByFilters(String name, Integer age, List<Long> movies, String order);

    CharacterDTO getById(Long characterId);

    CharacterDTO update(Long id, CharacterDTO characterDTO);

    void delete(Long characterId);
}
