package com.mayou.community.provider;

import com.alibaba.fastjson.JSON;
import com.mayou.community.dto.AccessTokenDTO;
import okhttp3.*;
import org.springframework.stereotype.Component;
import com.mayou.community.dto.GithubUser;

import java.io.IOException;

/**
 * @author yfzhang
 */
@Component
public class GithubProvider {

    private static final MediaType MediaType_JSON
            = MediaType.get("application/json; charset=utf-8");


    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), MediaType_JSON);        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();

            System.out.println(string);

            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);

            System.out.println(githubUser.toString());
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
