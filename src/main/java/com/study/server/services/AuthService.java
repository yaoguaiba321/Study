package com.study.server.services;

import com.study.server.entity.User;
import com.study.server.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class AuthService {

    @Autowired
    private UserDao userDao;

    public User login(String account, String nickname) {
        User user = this.userDao.selectUser(account);
        if (user == null) {
            user = new User(account, nickname);
            this.userDao.insertUser(user);
        }
        return user;
    }
}
