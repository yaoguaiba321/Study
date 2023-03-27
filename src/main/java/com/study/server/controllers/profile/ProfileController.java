package com.study.server.controllers.profile;

import com.study.server.common.BaseController;
import com.study.server.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController extends BaseController {

    @Autowired
    protected AuthService authService;

    @GetMapping
    public ProfileRes me() {
        return this.authService.getProfile();
    }

    @PutMapping
    public ProfileRes save(@Validated @RequestBody ProfileReq req) {
        return authService.modify(req);
    }

}
