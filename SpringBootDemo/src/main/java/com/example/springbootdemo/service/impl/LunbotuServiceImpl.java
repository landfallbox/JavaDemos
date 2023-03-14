package com.example.springbootdemo.service.impl;
import java.util.List;

import com.example.springbootdemo.entity.Lunbotu;
import com.example.springbootdemo.mapper.LunbotuMapper;
import com.example.springbootdemo.service.LunbotuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LunbotuServiceImpl implements LunbotuService {

    @Autowired
    private LunbotuMapper lunbotuMapper;

    @Override
    public List<Lunbotu> findBannerImgList() {
    
        return lunbotuMapper.findBannerImgList();
    }
    
}
