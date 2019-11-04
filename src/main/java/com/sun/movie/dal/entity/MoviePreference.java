package com.sun.movie.dal.entity;

import com.sun.movie.common.Base;
import lombok.Data;

@Data
public class MoviePreference extends Base {
    private long id;
    private long user_id;
    private long movie_id;
    private int preference;
    private int timestamp;
}
