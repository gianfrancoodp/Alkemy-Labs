package com.alkemy.disneyapi.controllers;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.dto.basic.GenreBasicDTO;
import com.alkemy.disneyapi.services.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {

    @Autowired
    private IGenreService genreService;

    @PostMapping
    public ResponseEntity<GenreBasicDTO> save(@RequestBody GenreDTO genre){
        GenreBasicDTO newGenre = genreService.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGenre);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> getAll(){
        List<GenreDTO> genres = genreService.getAll();
        return ResponseEntity.ok().body(genres);
    }

    @PutMapping("/{genreId}")
    public ResponseEntity<GenreDTO> update(@PathVariable Long genreId, @RequestBody GenreDTO genre){
        GenreDTO result = genreService.update(genreId, genre);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{genreId}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long genreId){
        genreService.delete(genreId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
