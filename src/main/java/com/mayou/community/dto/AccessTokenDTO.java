package com.mayou.community.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class AccessTokenDTO {
    private static String redirect_uri;
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;




}
