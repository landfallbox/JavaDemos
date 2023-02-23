package com.example.springbootdemo.util;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class WebResult {
    private Integer code;

    private String message;

    private Integer totalPages;

    private Integer currentPage;

    private Integer pageSize;

    private Object data;
}