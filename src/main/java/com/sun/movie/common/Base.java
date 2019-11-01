package com.sun.movie.common;

import com.alibaba.fastjson.JSON;

public class Base {
    public String toString() {
        return JSON.toJSONString(this);
    }
}
