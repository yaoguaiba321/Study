package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("")
public class User {

    //��¼ģ�� //����Ҫ���ò���ͬʱ��¼��̨�豸���ǣ�Ҳ���Ǽ�¼һ���ֶΣ�
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("12345");

    }
}
