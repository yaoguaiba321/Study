package com.study.server.dao;

import com.study.server.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User selectUser(@Param("account") String account);

    User findById(@Param("id") Long id);

    int insertUser(User user);

}
