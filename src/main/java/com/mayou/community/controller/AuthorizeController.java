package com.mayou.community.controller;

import com.mayou.community.dto.AccessTokenDTO;
import com.mayou.community.dto.GithubUser;
import com.mayou.community.pojo.User;
import com.mayou.community.provider.GithubProvider;
import com.mayou.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
                           HttpServletRequest request) {
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
            user.setToken("token");
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            int result = userService.insert(user);
            if (result > 0) {
                HttpSession session = request.getSession();
                session.setAttribute("userName", user.getName());
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
        request.getSession().setAttribute("userName", null);
        return "redirect:/";

    }
}
