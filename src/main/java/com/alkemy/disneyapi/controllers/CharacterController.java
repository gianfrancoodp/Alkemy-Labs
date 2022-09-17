package com.alkemy.disneyapi.controllers;

import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.dto.basic.CharacterBasicDTO;
import com.alkemy.disneyapi.services.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character) {
        CharacterDTO newCharacter = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCharacter);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CharacterDTO>> getAll() {
        List<CharacterDTO> characters = characterService.getAll();
        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterDTO> getById(@PathVariable Long characterId) {
        CharacterDTO result = characterService.getById(characterId);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> getByFilters(@RequestParam(required = false) String name,
                                                                @RequestParam(required = false) Integer age,
                                                                @RequestParam(required = false) List<Long> movies,
                                                                @RequestParam(required = false, defaultValue = "ASC") String order) {
        List<CharacterBasicDTO> characters = characterService.getByFilters(name, age, movies, order);
        return ResponseEntity.ok().body(characters);
    }

    @PutMapping("/{characterId}")
    public ResponseEntity<CharacterDTO> update(@PathVariable Long characterId, @RequestBody CharacterDTO characterDTO) {
        CharacterDTO result = characterService.update(characterId, characterDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{characterId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long characterId) {
        characterService.delete(characterId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
