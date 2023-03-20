package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Account {

    //��¼ģ�� //����Ҫ���ò���ͬʱ��¼��̨�豸���ǣ�Ҳ���Ǽ�¼һ���ֶΣ�
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("12345");

    }
}
