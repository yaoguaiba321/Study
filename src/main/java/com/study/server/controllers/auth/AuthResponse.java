package com.study.server.controllers.auth;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthResponse {
    @NotBlank(message = "请输入JWT")
    private String jwt;
}
