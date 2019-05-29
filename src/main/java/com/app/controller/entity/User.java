package com.app.controller.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package com.app.controller.entity
 * @ClassName User
 * @Author shaobin.wang
 * @Date 2019/05/27 9:19
 * @Version 1.0
 * @Description:
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 625776309390689037L;
    private String id;
    private String name;
    private String age;

    public User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
