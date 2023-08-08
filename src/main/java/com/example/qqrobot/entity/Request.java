package com.example.qqrobot.entity;

import lombok.Data;

/**
 * 一些声明信息
 * Description:
 * date: 2023/8/8 0:06
 *
 * @author shijie.yan
 * @since JDK 1.8
 */
@Data
public class Request<T> {
    private String action;
    private T params;
    private String echo;
}
