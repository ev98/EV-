package com.ev.blog.dao;

import com.ev.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Select("select * from t_user where username = #{username} and password = #{password}")
    User queryByUsernameAndPassword(String username,String password);

    //根据username查找学生
    @Select("select * from student where username=#{username}")
    User findByUsername(String username);
}
