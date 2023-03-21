package com.study.server.controllers.auth;

import com.study.server.entity.User;
import com.study.server.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AuthController {

    @Autowired
    protected AuthService authService;

    //��¼ģ�� //����Ҫ���ò���ͬʱ��¼��̨�豸���ǣ�Ҳ���Ǽ�¼һ���ֶΣ�
    @PostMapping("/login")
    AuthResponse login(@Validated @RequestBody AuthRequest request) {
        System.out.println("12345");
        User user = this.authService.login(request.getAccount(), request.getNickname());

        return this.makeResponse(user);
    }

    protected AuthResponse makeResponse(User user) {
        String jwt = this.authService.makeJWT(user);
        AuthResponse response = new AuthResponse();
        response.setJwt(jwt);
        return response;
    }


}
