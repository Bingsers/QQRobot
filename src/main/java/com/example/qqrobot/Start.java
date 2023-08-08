package com.example.qqrobot;

import com.example.qqrobot.ws.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 一些声明信息
 * Description:
 * date: 2023/8/7 23:37
 *
 * @author shijie.yan
 * @since JDK 1.8
 */
@Component
public class Start implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Client.connect("ws://127.0.0.1:4514");
    }
}
