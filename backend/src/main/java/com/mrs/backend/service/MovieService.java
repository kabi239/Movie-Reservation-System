package com.mrs.backend.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.backend.exceptions.ResourceNotFoundException;
import com.mrs.backend.model.Movie;
import com.mrs.backend.payload.MovieDTO;
import com.mrs.backend.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO,Movie.class);
        Movie createdMovie = movieRepository.save(movie);
        return modelMapper.map(createdMovie, MovieDTO.class);  
    }

    public List<MovieDTO> getMovies() { 
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(movie -> modelMapper.map(movie, MovieDTO.class)).toList();
    }

    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Movie", "movieId", id));
        return modelMapper.map(movie, MovieDTO.class);
    }

    public void deleteMovieById(Long id) {
        movieRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Movie", "movieId", id));
        movieRepository.deleteById(id);
    }

}
