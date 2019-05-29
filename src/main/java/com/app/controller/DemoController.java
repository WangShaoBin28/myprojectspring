package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.app.controller
 * @ClassName DemoController
 * @Author shaobin.wang
 * @Date 2019/05/29 11:55
 * @Version 1.0
 * @Description:
 **/
@RestController
public class DemoController {

    @RequestMapping("/")
    public String index() {
        return "<h1>Hello Jenkins<h1/>";
    }
}
