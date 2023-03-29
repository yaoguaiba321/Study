package com.study.server.controllers.item;

import com.study.server.common.BaseController;
import com.study.server.controllers.profile.ProfileReq;
import com.study.server.controllers.profile.ProfileRes;
import com.study.server.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;

@RestController
@RequestMapping("items")
public class ItemController extends BaseController {

    @Autowired
    protected ItemService itemService;

    @GetMapping
    public Array<ItemRes> list() {
        return this.itemService.getProfile();
    }

    @PutMapping
    public ProfileRes save(@Validated @RequestBody ProfileReq req) {
        return itemService.modify(req);
    }
}
