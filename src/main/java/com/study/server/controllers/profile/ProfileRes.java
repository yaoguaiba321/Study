package com.study.server.controllers.profile;

import lombok.Data;

@Data
public class ProfileRes {
    private Long id;
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
}
