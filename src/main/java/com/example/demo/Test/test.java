package com.example.demo.Test;


import com.example.demo.dao.AppDao;
import com.example.demo.domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class test {

    @Autowired
    AppDao app;

    @PostMapping("/testup")
    public String testupPage(Application application) {
        System.out.println(application.toString());
        System.out.println("测试");

        return "/jsp/forms";
    }


}
