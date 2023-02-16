package com.example.movies.controller;

import com.example.movies.model.Movie;
import com.example.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/saveMovies")
    public ResponseEntity<String> saveMovies(){
        movieService.saveAllMovies();
        return ResponseEntity.ok("Movies Saved in DB");
    }

    @GetMapping("/allMovies")
    public ResponseEntity<List<Movie>> allMovies(){
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<Integer> priceOfMovie(@PathVariable int id){
        return ResponseEntity.ok(movieService.findPrice(id));
    }

    @PostMapping("/watch/{id}")
    public ResponseEntity<String> watchMovie(@PathVariable int id) throws Exception{
        return ResponseEntity.ok("You are now watching "+movieService.watchMovie(id));
    }

}
