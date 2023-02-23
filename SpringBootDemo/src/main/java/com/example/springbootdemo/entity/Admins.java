package com.example.springbootdemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter @Getter @ToString
public class Admins extends BaseEntity implements Serializable {
    private Integer id;
    private String username;
    private String pwd;
    private String addtime;
}
