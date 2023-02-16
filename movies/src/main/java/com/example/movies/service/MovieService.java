package com.example.movies.service;

import com.example.movies.model.Movie;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {
    List<Movie> findAllMovies();
    void saveAllMovies();

    int findPrice(int id);

    String watchMovie(int id) throws Exception;
}
