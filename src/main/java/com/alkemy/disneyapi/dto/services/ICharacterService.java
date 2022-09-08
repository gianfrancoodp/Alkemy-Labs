package com.alkemy.disneyapi.dto.services;

import com.alkemy.disneyapi.dto.CharacterDTO;

import java.util.List;
import java.util.Set;

public interface ICharacterService {

    CharacterDTO save(CharacterDTO characterDTO);
    List<CharacterDTO> getAll();
    CharacterDTO update(Long id, CharacterDTO characterDTO);
    void delete(Long characterId);
}
