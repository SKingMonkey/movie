package com.sun.movie.service.display;

import com.sun.movie.common.vo.UserMovieInfo;
import com.sun.movie.dal.entity.Movie;
import com.sun.movie.mapper.MovieMapper;
import com.sun.movie.service.recommerder.ContentBasedService;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieDisplayService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ContentBasedService contentBasedService;

    public List<Movie> displayAllMovies() {
        return movieMapper.queryAllMovies();
    }

    public List<UserMovieInfo> getMovieByUserId(long userId) {
        return movieMapper.getMovieByUserId(userId);
    }

    public void update(Movie movie) {
        movieMapper.update(movie);
    }

    public List<Movie> getContentBasedRecommendMovie(long userId, int size) {
        List<RecommendedItem> recommendedItems = contentBasedService.getContentBasedRecommendedItem(userId, size);
        List<Long> movieIds = recommendedItems.stream().map(RecommendedItem::getItemID).collect(Collectors.toList());
        System.out.println(movieIds);
        return movieMapper.getMovieByIds(movieIds);
    }
}
