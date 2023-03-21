package com.study.server.services;

import com.study.server.dao.UserDao;
import com.study.server.entity.User;
import com.study.server.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Configurable
public class AuthService {

    @Autowired
    private UserDao userDao;

    @Autowired
    protected JwtHelper jwtHelper;

    public User login(String account, String nickname) {
        User user = this.userDao.selectUser(account);
        if (user == null) {
            user = new User(account, nickname);
            this.userDao.insertUser(user);
        }
        return user;
    }

    public String makeJWT(User user) {
        if (user == null) {
            return null;
        }
        Map<String, String> claims = new HashMap<>();
        claims.put("id", user.getId().toString());
        claims.put("account", user.getAccount());
        claims.put("nickname", user.getNickname());
        return jwtHelper.createJwtForClaims(user.getId().toString(), claims);
    }
}
