package services;

import common.entity.User;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserDao userDao;

    public User login(String account, String nickname) {
        User user = this.userDao.selectUser(account);
        if (user == null) {
            user =  new User();
            this.userDao.insertUser(user);
        }
        return user;
    }
}
