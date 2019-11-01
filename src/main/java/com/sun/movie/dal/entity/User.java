package com.sun.movie.dal.entity;

import com.sun.movie.common.Base;
import lombok.Data;

@Data
public class User extends Base {
    private int id;
    private String sex;
    private int age;
    private String profession;
    private String zip_code;
}
