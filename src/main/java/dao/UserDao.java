package dao;

import common.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User selectUser(@Param("account") String account);

    int insertUser(User user);

}
