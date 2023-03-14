package com.example.springbootdemo.mapper;

import java.util.List;

import com.example.springbootdemo.entity.TripLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TripLineMapper {

    @Select("select id, xianlubianhao, xianlumingcheng, tupian, chufadi, tujingdi, zhongdian ,jiage ,liulanliang ," +
            "xianlutese ,xianlujianjie ,addtime  from lvyouxianlu l order by id desc limit #{start},#{limit}")
    List<TripLine> findByPage(TripLine tripLine);

    @Select("select count(1) from lvyouxianlu")
    int findCount();
    
}
