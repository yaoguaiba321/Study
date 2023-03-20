package com.study.server.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5514139686858156155L;
    private Integer id;
    private String account;
    private String nickname;

    public User(String account, String nickname) {
        this.account = account;
        this.nickname = nickname;
    }

}
