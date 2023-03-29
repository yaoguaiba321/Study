package com.study.server.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {
    private static final long serialVersionUID = -5514139686858156155L;
    private Integer id;
    private String account;
    private String title;
    private String already;
    private String start_date;
    private String end_date;
    private String itemtag;
    private String color;
    private String itemnumber;
    private String attribution;
    private String needpractice;
    private Double learntimes;
    private Double practicetimes;
    private Integer totaldays;
    private Integer taskid;
    private String endtype;

    public Item(String account, String nickname) {
        this.account = account;
        this.title = nickname;
    }

}
