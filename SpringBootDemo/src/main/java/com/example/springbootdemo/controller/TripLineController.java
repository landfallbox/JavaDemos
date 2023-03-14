package com.example.springbootdemo.controller;

import java.util.List;

import com.example.springbootdemo.entity.TripLine;
import com.example.springbootdemo.service.TripLineService;
import com.example.springbootdemo.util.ResultCode;
import com.example.springbootdemo.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/trip")
public class TripLineController {

    @Autowired
    private TripLineService tripLineService;

    @RequestMapping("/lineByPage")
    public WebResult findTripLine(TripLine tripLine){
        List<TripLine> tripLineList = tripLineService.findByPage(tripLine);
        WebResult webResult = new WebResult();
        if(!CollectionUtils.isEmpty(tripLineList)){
            String[] imageArray;
            for(TripLine tripLineItem : tripLineList){
                imageArray = tripLineItem.getTupian().split(",");
                tripLineItem.setImage1("/" + imageArray[0]);
                tripLineItem.setImage2("/" + imageArray[1]);
            }
            webResult.setCode(ResultCode.Succeed.value());
            webResult.setMessage("成功获取旅游线路信息");
            webResult.setData(tripLineList);
        }else{
            webResult.setCode(ResultCode.Failure.value());
            webResult.setMessage("获取旅游线路信息失败");
        }
        return webResult;
    } 
}
