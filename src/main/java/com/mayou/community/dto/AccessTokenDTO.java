package com.mayou.community.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String redirect_url;
    private String code;
    private String state;




}
