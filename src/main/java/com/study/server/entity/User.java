package com.study.server.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5514139686858156155L;
    private Integer id;
    private String account;
    private String nickname;
    private String touxiang;
    private String gender;
    private String birthday;
    private String introduction;
    private String life;
    private String vip;
    private Boolean showitem;
    private Boolean showaim;
    private Boolean showrank;
    private Boolean landscapemode;
    private Boolean hasreport;
    private Boolean currency;

    public User(String account, String nickname) {
        this.account = account;
        this.nickname = nickname;
    }

}
