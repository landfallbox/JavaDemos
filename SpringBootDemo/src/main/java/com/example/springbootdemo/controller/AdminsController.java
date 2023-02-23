package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Admins;
import com.example.springbootdemo.mapper.AdminsMapper;

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
}
