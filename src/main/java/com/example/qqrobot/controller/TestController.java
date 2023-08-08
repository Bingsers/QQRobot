package com.example.qqrobot.controller;

import com.example.qqrobot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一些声明信息
 * Description:
 * date: 2023/8/7 19:53
 *
 * @author shijie.yan
 * @since JDK 1.8
 */
@RequestMapping("/TestController")
public class TestController {
    @Autowired
    TestService testService;

    @PostMapping("/sendMessage")
    public String SendMessage(@RequestBody String msg){
        return testService.sendMessage(msg);
    }
}
