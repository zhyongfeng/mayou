package com.mayou.community.controller;

import com.mayou.community.dto.AccessTokenDTO;
import com.mayou.community.dto.GithubUser;
import com.mayou.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
        GithubUser user = githubProvider.getUser(access_token);
        if (null != user) {
            //登录成功，写cookie和session
            request.getSession().setAttribute("user", user);
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
