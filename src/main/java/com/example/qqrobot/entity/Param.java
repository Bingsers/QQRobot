package com.example.qqrobot.entity;

import lombok.Data;
import org.springframework.lang.NonNullApi;

/**
 * 一些声明信息
 * Description:
 * date: 2023/8/8 0:04
 *
 * @author shijie.yan
 * @since JDK 1.8
 */
@Data
public class Param {
    //消息类型
    private String message_type;
    //目标qq
    private String user_id;
    //
    private String group_id;
    private String message;
    private Boolean auto_escape;
}
