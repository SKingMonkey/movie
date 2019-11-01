package com.sun.movie.dal.entity;

import com.sun.movie.common.Base;
import lombok.Data;

@Data
public class MoviePreference extends Base {
    private int id;
    private int user_id;
    private int movie_id;
    private int preference;
    private int timestamp;
}
