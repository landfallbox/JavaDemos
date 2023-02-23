package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.Admins;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminsMapper {
    @Select("select id,username,pwd,addtime from admins where id = #{id}")
    Admins findById(long id);

    @Select("select id,username,pwd,addtime from admins where username = #{username}")
    Admins findByUsername(String username);

    @Insert("INSERT INTO admins (username,pwd,addtime) VALUES( #{username}, #{pwd}, CURRENT_TIMESTAMP())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Admins admins);
}
