package com.sun.movie.display.service;

import com.sun.movie.dal.entity.Movie;
import com.sun.movie.dal.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDisplayService {

    @Autowired
    private MovieMapper movieMapper;

    public List<Movie> displayAllMovies() {
        return movieMapper.queryAllMovies();
    }
}
