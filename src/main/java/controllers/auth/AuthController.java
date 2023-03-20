package controllers.auth;

import common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.AuthService;

@RestController
//@RequestMapping("")
public class AuthController {

    @Autowired
    protected AuthService authService;

    //��¼ģ�� //����Ҫ���ò���ͬʱ��¼��̨�豸���ǣ�Ҳ���Ǽ�¼һ���ֶΣ�
    @PostMapping("/login")
    User login(@Validated @RequestBody AuthRequest request) {
        System.out.println("12345");
        return this.authService.login(request.getAccount(), request.getNickname());
    }
}
