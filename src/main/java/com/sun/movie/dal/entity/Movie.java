package com.sun.movie.dal.entity;

import com.sun.movie.common.Base;
import lombok.Data;

@Data
public class Movie extends Base {
    private long id;
    private String name;
    private String published_year;
    private String category;
}
