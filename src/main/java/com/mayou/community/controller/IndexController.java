package com.mayou.community.controller;

import com.mayou.community.model.User;
import com.mayou.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @Autowired
    UserService userService;

    @RequestMapping("/find")
    public User findByName(){
        /*因为没写前端页面，这里写了些伪业务代码*/
        User user = userService.findByName("李四");
        return user;
    }

    @RequestMapping("/findall")
    public List<User> findAll(){
        List<User> users =userService.findAll();
        return users;
    }
}
