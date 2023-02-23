package com.example.springbootdemo.service.impl;



import com.example.springbootdemo.entity.Admins;
import com.example.springbootdemo.mapper.AdminsMapper;
import com.example.springbootdemo.service.AdminsService;
import com.example.springbootdemo.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminsServiceImpl implements AdminsService {

    @Autowired
    private AdminsMapper adminsMapper;

    /**
     * 
     */
    public Admins login(Admins admins){
        return adminsMapper.findByUsernameAndPassword(admins);
    }

    @Override
    public List<Admins> findByPage(Admins admins) {

        List<Admins> adminsList;
        int totalCount = adminsMapper.findCount();
        if (totalCount > 0) {
            PageHelper pageHelper = new PageHelper();
            pageHelper.setPageSize(admins.getPageSize());
            pageHelper.setRecordCount(totalCount);
            admins.setStart(pageHelper.getOffset(admins.getCurrentPage()));
            admins.setLimit(admins.getPageSize());
            adminsList = adminsMapper.findByPage(admins);
        } else {
            adminsList = new ArrayList<Admins>();
        }

        return adminsList;

    }
    
}
