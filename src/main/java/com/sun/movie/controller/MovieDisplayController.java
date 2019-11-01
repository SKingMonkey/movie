package com.sun.movie.controller;

import com.sun.movie.common.RecommendResponse;
import com.sun.movie.display.service.MovieDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieDisplayController {
    @Autowired
    private MovieDisplayService movieDisplayService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public RecommendResponse getAllMovies() {
        try {
            return RecommendResponse.success(movieDisplayService.displayAllMovies());
        } catch (Exception e) {
            return RecommendResponse.fail(e);
        }
    }
}
