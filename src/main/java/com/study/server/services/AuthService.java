package com.study.server.services;

import com.nimbusds.jwt.SignedJWT;
import com.study.server.dao.UserDao;
import com.study.server.entity.User;
import com.study.server.excepiton.StudyException;
import com.study.server.excepiton.SystemException;
import com.study.server.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
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

    public User refreshUserByToken(String token) {
        String idStr = null;
        try {
            SignedJWT jwt = SignedJWT.parse(token);
            idStr = jwt.getJWTClaimsSet().getStringClaim("id");
        } catch (ParseException e) {
            throw new StudyException("令牌无效");
        }
        if (!StringUtils.hasLength(idStr)) {
            throw new SystemException("jwt token中没有用户id");
        }
        Long id = Long.parseLong(idStr);
        User user = this.userDao.findById(id);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("用户「%d」不存在", id));
        }
        return user;
    }
}
