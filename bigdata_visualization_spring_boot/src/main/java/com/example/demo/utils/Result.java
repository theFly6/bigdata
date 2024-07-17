package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private T data;
    private String message;

    public static <T> Result<T> success(T data) {
        return new Result<>(200,data,"操作成功");
    }

    public static <E> Result<E> success() {
        return new Result<>(200,null,"操作成功");
    }
    public static <E> Result<E> error(String message) {
        return new Result<>(400,null,message);
    }

    public static <T> Result<T> error(T data) {
        return new Result<>(400,data,"失败");
    }
}
