package com.study.server.controllers.item;

import com.study.server.common.BaseController;
import com.study.server.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController extends BaseController {

    @Autowired
    protected ItemService itemService;

    @GetMapping
    public List<ItemRes> list() {

        return itemService.list();
    }

    @GetMapping("/{id}")
    public ItemRes detail(@PathVariable("id") Long itemId) {
        return itemService.detail(itemId);
    }

//    @PutMapping
//    public ProfileRes save(@Validated @RequestBody ProfileReq req) {
//        return itemService.modify(req);
//    }
}
