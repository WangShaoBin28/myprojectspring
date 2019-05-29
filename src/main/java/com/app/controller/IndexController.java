package com.app.controller;

import com.app.controller.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.app.controller
 * @ClassName index
 * @Author shaobin.wang
 * @Date 2019/05/27 9:18
 * @Version 1.0
 * @Description:
 **/
@RestController
@Slf4j
@RequestMapping("/index/")
public class IndexController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("index")
    @Cacheable(value = "therapyOrder", key = "#id+'_therapyOrder'", unless = "#result ==null")
    public User getUser(@RequestParam("id") String id) {
        redisTemplate.opsForValue().set("therapyOrder::" + id + "_therapyOrder", "{id:'2',name:'张三',age:'1'}");
        log.info("查询库----");
        User user = new User("1", "张三疯", "50");
        return user;
    }
}
