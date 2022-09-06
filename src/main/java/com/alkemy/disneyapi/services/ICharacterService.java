package com.alkemy.disneyapi.services;

import com.alkemy.disneyapi.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {

    CharacterDTO save(CharacterDTO characterDTO);
    List<CharacterDTO> getAll();
    CharacterDTO update(Long id, CharacterDTO characterDTO);
    void delete(Long characterId);
}