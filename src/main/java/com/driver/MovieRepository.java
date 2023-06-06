package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    private Map<String,Movie> movieMap=new HashMap<>();
    private Map<String,Director> directorMap=new HashMap<>();
    private Map<String, List<String>> movieDirectorMap=new HashMap<>();
    public String addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
        return "SUCCESS";
    }
    public Movie getMovie(String name){
        return movieMap.get(name);
    }
    public String addDirector(Director director){
        directorMap.put(director.getName(),director);
        return "SUCESS";
    }
    public String addMovieDirector(String movie, String director){
        if(!movieMap.containsKey(movie) || !directorMap.containsKey(director)) return "Failure";
        List<String> str;
        if(movieDirectorMap.containsKey(director)){
                str = movieDirectorMap.get(director);
        }
        else{
            str = new ArrayList<>();
        }
        str.add(movie);
        movieDirectorMap.put(director,str);
        return "SUCCESS";
    }
    public Director getDirector(String name){
        return directorMap.get(name);
    }
    public List<Movie> getMoviesByDirectorName(String name){
        if(movieDirectorMap.containsKey(name)){
            List<String> names=movieDirectorMap.get(name);
            List<Movie> str=new ArrayList<>();
            for(String n : names){
                str.add(movieMap.get(n));
            }
            return str;
        }
        return null;
    }
    public List<Movie> findAllMovies(){
        return new ArrayList<>(movieMap.values());
    }
    public String deleteDirectorByName(String name){
        if(directorMap.containsKey(name)){
            directorMap.remove(name);
        }
        List<String> names=movieDirectorMap.get(name);
        for(String n:names){
            movieMap.remove(n);
        }
        if(movieDirectorMap.containsKey(name)){
            movieDirectorMap.remove(name);
        }
        return "SUCCESS";
    }
    public String deleteAllDirectors(){
        directorMap.clear();
        for(String name:movieDirectorMap.keySet()){
            List<String> names=movieDirectorMap.get(name);
            for(String n:names){
                if(movieMap.containsKey(n)) movieMap.remove(n);
            }
        }
        return "SUCCESS";
    }
}