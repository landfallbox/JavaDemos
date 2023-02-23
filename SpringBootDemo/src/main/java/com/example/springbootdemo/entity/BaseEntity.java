package com.example.springbootdemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseEntity {
    private Integer currentPage;

    private Integer pageSize;

    private Integer start;

    private Integer limit;

    private Integer totalPages;
}

