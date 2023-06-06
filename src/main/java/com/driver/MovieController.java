package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    ResponseEntity<?> addMovie(@RequestBody Movie movie){
        ResponseEntity<String> responseEntity=new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @PostMapping("/addDirector")
    ResponseEntity<?> addDirector(@RequestBody Director director){
        ResponseEntity<String> responseEntity=new ResponseEntity<>(movieService.addDirector(director),HttpStatus.ACCEPTED);
        return  responseEntity;
    }

    @GetMapping("/getMovieByName")
    ResponseEntity<?> getMovieByName(@RequestParam String name){
        ResponseEntity<Movie> responseEntity=new ResponseEntity<>(movieService.getMovie(name),HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping("/addMovieDirectorPair")
    ResponseEntity<?> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        ResponseEntity<String> responseEntity=new ResponseEntity<>(movieService.addMovieDirector(movie,director),HttpStatus.ACCEPTED);
        return responseEntity;
    }
    @GetMapping("/getDirectorByName")
    ResponseEntity getDirectorByName(@RequestParam String name){
        return new ResponseEntity(movieService.getDirector(name),HttpStatus.OK);
    }
    @GetMapping("/getMoviesByDirectorName")
    ResponseEntity getMoviesByDirectorName(@RequestParam String name){
        return new ResponseEntity(movieService.getMoviesByDirectorName(name),HttpStatus.OK);
    }
    @GetMapping("/findAllMovies")
    ResponseEntity findAllMovies(){
        return new ResponseEntity(movieService.findAllMovies(),HttpStatus.OK);
    }
    @DeleteMapping("/deleteDirectorByName")
    ResponseEntity deleteDirectorByName(@RequestParam String name){
        return new ResponseEntity(movieService.deleteDirectorByName(name),HttpStatus.OK);
    }
    @DeleteMapping("/deleteAllDirectors")
    ResponseEntity deleteAllDirectors(){
        return new ResponseEntity(movieService.deleteAllDirectors(),HttpStatus.OK);
    }
}
