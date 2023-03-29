package com.study.server.services;


import com.study.server.controllers.item.ItemRes;
import com.study.server.dao.ItemDao;
import com.study.server.dao.UserDao;
import com.study.server.entity.User;
import com.study.server.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class ItemService {
    @Autowired
    private AuthService authService;
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ItemMapper itemMapper;

    public List<ItemRes> list() {
        Long uid = authService.getUid();
        User user = userDao.findById(uid);

        return itemMapper.toItemReses(this.itemDao.findAllByAccount(user.getAccount()));
    }

}
