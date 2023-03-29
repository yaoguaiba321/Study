package com.study.server.mapper;

import com.study.server.controllers.item.ItemRes;
import com.study.server.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemRes toItemRes(Item item);

    List<ItemRes> toItemReses(List<Item> items);
}
