package com.study.server.controllers.item;

import lombok.Data;

@Data
public class ItemRes {

    private Integer id;
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
}
