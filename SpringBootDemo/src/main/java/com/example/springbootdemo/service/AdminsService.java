package com.example.springbootdemo.service;


import com.example.springbootdemo.entity.Admins;

import java.util.List;

public interface AdminsService {

    Admins login(Admins admins);

    /**
     * 分页返回数据
     * @param admins
     * @return
     */
    List<Admins> findByPage(Admins admins);
}
