package com.xzh.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequest implements Serializable {

    private String name;
    private String title;
    private String phone;
    private String wechat;
}
