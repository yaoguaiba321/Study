package com.study.server.controllers.auth;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthRequest {
    @NotEmpty(message = "Please input account")
    private String account;

    private String nickname;

}
