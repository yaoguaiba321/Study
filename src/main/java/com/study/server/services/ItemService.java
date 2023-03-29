package com.study.server.services;


import com.study.server.controllers.item.ItemRes;
import com.study.server.dao.ItemDao;
import com.study.server.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public List<ItemRes> list(String account, String nickname) {
        List<Item> list = this.itemDao.findAllByAccount(account);

        return list;
    }

}
