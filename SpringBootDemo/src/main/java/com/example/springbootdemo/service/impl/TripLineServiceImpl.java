package com.example.springbootdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.springbootdemo.entity.TripLine;
import com.example.springbootdemo.mapper.TripLineMapper;
import com.example.springbootdemo.service.TripLineService;
import com.example.springbootdemo.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TripLineServiceImpl implements TripLineService {
    @Autowired
    private TripLineMapper tripLineMapper;

    @Override
    public List<TripLine> findByPage(TripLine tripLine) {

        List<TripLine> tripLineList;
        int totalCount = tripLineMapper.findCount();
        if (totalCount > 0) {
            PageHelper pageHelper = new PageHelper();
            pageHelper.setPageSize(tripLine.getPageSize());
            pageHelper.setRecordCount(totalCount);
            tripLine.setStart(pageHelper.getOffset(tripLine.getCurrentPage()));
            tripLine.setLimit(tripLine.getPageSize());
            tripLineList = tripLineMapper.findByPage(tripLine);
        } else {
            tripLineList = new ArrayList<TripLine>();
        }
        return tripLineList;
    } 
}
