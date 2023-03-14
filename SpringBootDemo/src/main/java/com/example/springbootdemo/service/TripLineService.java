package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.TripLine;

import java.util.List;


public interface TripLineService {
    
    List<TripLine> findByPage(TripLine tripLine);
}
