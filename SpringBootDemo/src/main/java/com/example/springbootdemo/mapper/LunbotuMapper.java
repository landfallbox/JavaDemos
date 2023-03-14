package com.example.springbootdemo.mapper;

import java.util.List;

import com.example.springbootdemo.entity.Lunbotu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LunbotuMapper {

    @Select("select id,title,image,url,addtime from lunbotu order by id desc limit 0,5")
    List<Lunbotu> findBannerImgList();
    
    
}
