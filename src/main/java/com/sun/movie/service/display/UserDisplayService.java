package com.sun.movie.service.display;

import com.sun.movie.dal.entity.User;
import com.sun.movie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDisplayService {
    @Autowired
    private UserMapper userMapper;

    public List<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }

    public User getUserById(long userId) {
        return userMapper.getUserById(userId);
    }
}
