package com.example.movies;


import com.example.movies.service.Impl.MovieServiceImpl;
import com.example.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MoviesApplication {

    public static void main(String[] args) {

        SpringApplication.run(MoviesApplication.class, args);
    }

}
