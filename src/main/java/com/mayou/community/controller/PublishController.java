package com.mayou.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: yfzhang
 * @Description:
 * @Date: Created in 3:14 PM 2020/3/27
 * @Modified By:
 */
@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
}
