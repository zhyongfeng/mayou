package com.mayou.community.controller;

import com.mayou.community.dto.AccessTokenDTO;
import com.mayou.community.dto.GithubUser;
import com.mayou.community.provider.GithubProvider;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import okhttp3.Request;
=======
>>>>>>> 5d3f5ccb63797960e4d777f7e47be0bd2b2a48fd
>>>>>>> 2051447fbc9736148d79acb731868a1ebb792a96
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 2051447fbc9736148d79acb731868a1ebb792a96
import javax.servlet.http.HttpServletRequest;

<<<<<<< HEAD
=======
=======
>>>>>>> 5d3f5ccb63797960e4d777f7e47be0bd2b2a48fd
>>>>>>> 2051447fbc9736148d79acb731868a1ebb792a96
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 2051447fbc9736148d79acb731868a1ebb792a96
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
<<<<<<< HEAD
=======
=======
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){


        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();

>>>>>>> 5d3f5ccb63797960e4d777f7e47be0bd2b2a48fd
>>>>>>> 2051447fbc9736148d79acb731868a1ebb792a96
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 2051447fbc9736148d79acb731868a1ebb792a96
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
<<<<<<< HEAD
=======
=======

        String access_token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(access_token);

        System.out.println("user name: " + user.getName());
        return "index";
>>>>>>> 5d3f5ccb63797960e4d777f7e47be0bd2b2a48fd
>>>>>>> 2051447fbc9736148d79acb731868a1ebb792a96
    }
}
