package com.sun.movie.validator;

import com.sun.movie.common.RecommendException;
import com.sun.movie.dal.entity.User;
import com.sun.movie.service.display.UserDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExistValidator {

    @Autowired
    private UserDisplayService userDisplayService;

    public void checkValid(long userId) throws RecommendException {
        User exist = userDisplayService.getUserById(userId);
        if (exist == null) {
            throw RecommendException.build(404, "用户不存在");
        }
    }
}
