package com.sun.movie.service;

import com.sun.movie.dal.entity.Movie;
import com.sun.movie.service.display.MovieDisplayService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class MovieDisplayServiceTest {

    @Autowired
    private MovieDisplayService movieDisplayService;

    @Test
    void displayAllMovies() {
        System.out.println(movieDisplayService.displayAllMovies());
    }

    @Test
    void update() {
        List<Movie> movies = movieDisplayService.displayAllMovies();
        for (Movie movie : movies) {
            String category = movie.getCategory().trim();
            movie.setCategory(category);
            movieDisplayService.update(movie);
        }
    }

    @Test
    void getContentBasedRecommendMovie() {
        movieDisplayService.getContentBasedRecommendMovie(223, 10);
    }
}