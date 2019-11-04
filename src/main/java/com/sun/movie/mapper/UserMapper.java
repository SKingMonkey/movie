package com.sun.movie.mapper;

import com.sun.movie.dal.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(User user);
    List<User> queryAllUsers();
    User getUserById(@Param("id") long id);
}
