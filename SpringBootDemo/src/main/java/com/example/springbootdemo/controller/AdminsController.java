package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Admins;
import com.example.springbootdemo.mapper.AdminsMapper;

import com.example.springbootdemo.service.AdminsService;
import com.example.springbootdemo.util.ResultCode;
import com.example.springbootdemo.util.WebResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminsController {
    @Autowired
    private AdminsMapper adminsMapper;

    @Autowired
    private AdminsService adminsService;

    @RequestMapping("/find")
    public Admins findById(Long id){
        Admins admins;

        if(id != null){
            admins = adminsMapper.findById(id);
        }
        else{
            admins = new Admins();
            admins.setId(0);
            admins.setUsername("haha");
            admins.setPwd("111111");
        }

        return admins;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public Admins addAdmin(Admins admins){
        Admins result = null;

        if(admins != null && !StringUtils.isEmpty(admins.getUsername()) && !StringUtils.isEmpty(admins.getPwd())){
            Admins adminsInDB = adminsMapper.findByUsername(admins.getUsername());

            if(adminsInDB == null){
                adminsMapper.insert(admins);
                result = adminsMapper.findByUsername(admins.getUsername());
            }
        }

        if(result == null){
            result = new Admins();
            result.setId(0);
            result.setPwd("11111");
            result.setUsername("haha");
        }

        return result;
    }

    @RequestMapping("findByPage")
    public WebResult findByPage(Admins admins){
        WebResult webResult = new WebResult();

        if(admins.getCurrentPage() != null && admins.getPageSize() != null){
            webResult.setCode(ResultCode.Succeed.value());
            webResult.setMessage("返回管理员列表");
            webResult.setCurrentPage(admins.getCurrentPage());
            webResult.setPageSize(admins.getPageSize());
            webResult.setData(adminsService.findByPage(admins));
        }
        else{
            webResult.setCode(ResultCode.Failure.value());
            webResult.setMessage("缺失当前页或页面数量入参");
        }

        return webResult;
    }
}
