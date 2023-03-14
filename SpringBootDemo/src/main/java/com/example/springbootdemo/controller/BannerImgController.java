package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Lunbotu;
import com.example.springbootdemo.service.LunbotuService;
import com.example.springbootdemo.util.ResultCode;
import com.example.springbootdemo.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerImgController {

    @Autowired
    private LunbotuService lunbotuService;

    @RequestMapping("/imgList")
    public WebResult findBannerImgList() {
        List<Lunbotu> lunbotuList = lunbotuService.findBannerImgList();
        WebResult webResult = new WebResult();
        if (!CollectionUtils.isEmpty(lunbotuList)) {
            for(Lunbotu lunbotu : lunbotuList){
                lunbotu.setImage("/"+lunbotu.getImage());
            }
            webResult.setCode(ResultCode.Succeed.value());
            webResult.setMessage("查询轮播图成功");
            webResult.setData(lunbotuList);
        } else {
            webResult.setCode(ResultCode.Failure.value());
            webResult.setMessage("查询轮播图失败");
        }
        return webResult;
    }
}
