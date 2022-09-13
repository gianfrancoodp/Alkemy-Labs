package com.alkemy.disneyapi.controllers;

import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.dto.basic.MovieBasicDTO;
import com.alkemy.disneyapi.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie) {
        MovieDTO newMovie = movieService.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }

    @PostMapping("/{movieId}/characters/{characterId}")
    public ResponseEntity<MovieDTO> addCharacterToMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
        MovieDTO result = movieService.addCharacterToMovie(movieId, characterId);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAll() {
        List<MovieDTO> movies = movieService.getAll();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDTO> getById(@PathVariable Long movieId) {
        MovieDTO result = movieService.getById(movieId);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getByFilters(@RequestParam(required = false) String title,
                                                            @RequestParam(required = false) Long idGenre,
                                                            @RequestParam(required = false, defaultValue = "ASC") String order) {
        List<MovieBasicDTO> movies = movieService.getByFilters(title, idGenre, order);
        return ResponseEntity.ok().body(movies);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long movieId, @RequestBody MovieDTO movieDTO) {
        MovieDTO result = movieService.update(movieId, movieDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
        movieService.delete(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{movieId}/characters/{characterId}")
    public ResponseEntity<MovieDTO> deleteCharacterFromMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
        MovieDTO result = movieService.deleteCharacterFromMovie(movieId, characterId);
        return ResponseEntity.ok().body(result);
    }

}
