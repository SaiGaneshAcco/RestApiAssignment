package com.example.movies.service.Impl;

import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import com.example.movies.service.MovieService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void saveAllMovies() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Beans.xml");

        List<Movie> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String str = "movie" + i;
            Movie mv = (Movie) context.getBean(str);
            list.add(mv);
        }
        movieRepository.saveAll(list);
    }

    @Override
    public int findPrice(int id) {
        Optional<Movie> movie=movieRepository.findById(id);
        if(movie.isPresent())
            return movie.get().getPrice();
        else
            throw new NullPointerException("Movie Not Found");
    }

    @Override
    public String watchMovie(int id) throws Exception {
        Optional<Movie> movie=movieRepository.findById(id);
        if(movie.isPresent())
            return movie.get().getMovieName();
        else
            throw new NullPointerException("Movie Not Found");
    }
}
