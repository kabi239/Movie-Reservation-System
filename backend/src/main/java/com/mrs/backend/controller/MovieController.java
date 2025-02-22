package com.mrs.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrs.backend.payload.MovieDTO;
import com.mrs.backend.service.MovieService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("movie")
    public ResponseEntity<MovieDTO> addMovie(@Valid @RequestBody MovieDTO movieDTO) {
       MovieDTO movie = movieService.addMovie(movieDTO);
       return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("movies")
    public ResponseEntity<List<MovieDTO>> getMovies() {
        List<MovieDTO> movies = movieService.getMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        MovieDTO movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
