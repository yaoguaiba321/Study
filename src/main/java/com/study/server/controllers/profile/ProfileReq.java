package com.study.server.controllers.profile;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class ProfileReq {

    @NotNull(message = "请输入昵称")
    @Length(min = 1, max = 50, message = "昵称长度在1-50之间")
    private String nickName;
}
