package com.sun.movie.common;

public class RecommendException extends Exception {
    private int code = 400;

    public RecommendException(String message) {
        super(message);
    }
    public RecommendException(String message, Throwable t) {
        super(message, t);
    }
    public RecommendException(int code, String message) {
        super(message);
        this.code = code;
    }

    public static RecommendException build(int code, String message) {
        return new RecommendException(code, message);
    }
}
