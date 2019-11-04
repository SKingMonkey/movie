package com.sun.movie.controller;

import com.sun.movie.common.RecommendException;
import com.sun.movie.common.RecommendResponse;
import com.sun.movie.service.display.MovieDisplayService;
import com.sun.movie.validator.UserExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieDisplayController {
    @Autowired
    private MovieDisplayService movieDisplayService;
    @Autowired
    private UserExistValidator userExistValidator;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public RecommendResponse getAllMovies() {
        try {
            return RecommendResponse.success(movieDisplayService.displayAllMovies());
        } catch (Exception e) {
            return RecommendResponse.fail(e);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public RecommendResponse getMovieByUserId(@PathVariable long id) {
        try {
            userExistValidator.checkValid(id);
            return RecommendResponse.success(movieDisplayService.getMovieByUserId(id));
        } catch (RecommendException e) {
            return RecommendResponse.fail(e);
        } catch (Exception e) {
            e.printStackTrace();
            return RecommendResponse.fail(e);
        }
    }

    @RequestMapping(value = "/users/{id}/recommend/movies", method = RequestMethod.GET)
    public RecommendResponse getRecommendMovieByUserId(@PathVariable long id) {
        try {
            userExistValidator.checkValid(id);
            return RecommendResponse.success(movieDisplayService.getContentBasedRecommendMovie(id, 10));
        } catch (RecommendException e) {
            return RecommendResponse.fail(e);
        } catch (Exception e) {
            e.printStackTrace();
            return RecommendResponse.fail(e);
        }
    }
}
