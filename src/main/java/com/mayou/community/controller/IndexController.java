package com.mayou.community.controller;

import com.mayou.community.pojo.User;
import com.mayou.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @Autowired
    UserService userService;

    @RequestMapping("/find")
    public User findById(){
        /*因为没写前端页面，这里写了些伪业务代码*/
        User user = userService.findById(1);
        return user;
    }

}
