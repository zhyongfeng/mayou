package bro.mayou.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yfzhang
 * @Description:
 * @Date: Created in 8:29 PM 2020/2/8
 * @Modified By:
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);
        return "hello";
    }
}


