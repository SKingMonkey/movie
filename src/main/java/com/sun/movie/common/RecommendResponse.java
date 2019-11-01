package com.sun.movie.common;

import lombok.Data;

@Data
public class RecommendResponse extends Base {
    private int code;
    private String message;
    private Object result;

    public RecommendResponse() {}
    public RecommendResponse(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static RecommendResponse success() {
        return new RecommendResponse(200, "成功", null);
    }

    public static RecommendResponse success(Object result) {
        return new RecommendResponse(200, "成功", result);
    }

    public static RecommendResponse fail(Object result) {
        return new RecommendResponse(400, "失败", result);
    }

    public static RecommendResponse fail() {
        return new RecommendResponse(400, "失败", null);
    }
}
