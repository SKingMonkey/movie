package com.sun.movie.common.vo;

import com.sun.movie.common.Base;
import lombok.Data;

@Data
public class UserMovieInfo extends Base {
    private int movie_id;
    private String name;
    private String published_year;
    private String category;
    private int preference;
    private int timestamp;
}
