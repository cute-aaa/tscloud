package com.tscloud.user;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Component
@Transactional
public interface UserMapper {
    @Select("select * from users where username = #{username}")
    User findUserByName(String username);

    @Update("update users set username = #{username}, password = #{password} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from users where id = #{id}")
    void deleteUserByID(Integer id);

    @Insert("insert into users(username, password, usertype) values(#{username}, #{password}, #{usertype}")
    void addUser(User user);
}
