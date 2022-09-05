package com.alkemy.disneyapi.controllers;

import com.alkemy.disneyapi.dto.MovieDTO;
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
    private IMovieService movieService; //TODO: Revisar si va IMovieService o MovieService, es importante!!!!

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
        MovieDTO newMovie = movieService.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAll(){
        List<MovieDTO> movies = movieService.getAll();
        return ResponseEntity.ok().body(movies);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long movieId, @RequestBody MovieDTO movieDTO){
        MovieDTO result = movieService.update(movieId, movieDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId){
        movieService.delete(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
