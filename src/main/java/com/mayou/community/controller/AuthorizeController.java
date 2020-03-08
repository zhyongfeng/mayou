package com.mayou.community.controller;

import com.mayou.community.pojo.User;
import com.mayou.community.dto.AccessTokenDTO;
import com.mayou.community.dto.GithubUser;
import com.mayou.community.provider.GithubProvider;
import com.mayou.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author yfzhang
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired
    UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);
        String access_token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(access_token);
        if (null != githubUser) {
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName("永峰");
            user.setAccountId("Arthur");
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            int result = userService.insert(user);
            if (result > 0) {
                //登录成功，写cookie和session
                response.addCookie(new Cookie("token", token));
            }
            return "redirect:/";
        } else {
            //登录失败
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String callback(
            HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return "redirect:/";

    }
}
