package com.study.server.dao;

import com.study.server.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemDao {

    Item selectItem(@Param("account") String account);

    Item findById(@Param("id") Long id);

    List<Item> findAllByAccount(@Param("account") String account);

    int insertItem(Item item);

    int updateItem(Item item);
}
