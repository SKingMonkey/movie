package com.sun.movie.dal.mapper;

import com.sun.movie.dal.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface MovieMapper {
    List<Movie> queryAllMovies();
    Movie getMovieById(@Param("id") int id);
}
