package com.sun.movie.mapper;

import com.sun.movie.common.vo.UserMovieInfo;
import com.sun.movie.dal.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
    void update(Movie movie);
    List<Movie> queryAllMovies();
    List<Movie> getMovieByIds(@Param("ids") List<Long> ids);
    List<UserMovieInfo> getMovieByUserId(@Param("userId") long userId);
}
