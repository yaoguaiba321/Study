package com.study.server.dao;

import com.study.server.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User selectUser(@Param("account") String account);

    int insertUser(User user);

}
