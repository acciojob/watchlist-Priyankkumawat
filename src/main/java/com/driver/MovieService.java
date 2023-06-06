package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    public Movie getMovie(String name) {return movieRepository.getMovie(name);}
    public String addDirector(Director director) {return movieRepository.addDirector(director);}
    public String addMovieDirector(String movie,String director) {return movieRepository.addMovieDirector(movie,director);}
    public Director getDirector(String name) {return movieRepository.getDirector(name);}
    public List<String> getMoviesByDirectorName(String name){ return movieRepository.getMoviesByDirectorName(name);}
    public List<Movie> findAllMovies(){return movieRepository.findAllMovies();}
    public String deleteDirectorByName(String name){ return movieRepository.deleteDirectorByName(name);}
    public String deleteAllDirectors(){return movieRepository.deleteAllDirectors();}
}
