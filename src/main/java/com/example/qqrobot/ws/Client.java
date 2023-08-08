package com.example.qqrobot.ws;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.qqrobot.entity.Message;
import com.example.qqrobot.entity.Param;
import com.example.qqrobot.entity.Request;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

/**
 * 一些声明信息
 * Description:
 * date: 2023/8/7 23:30
 *
 * @author shijie.yan
 * @since JDK 1.8
 */
@ClientEndpoint
public class Client {
    private Session sessions;
    private static Client INSTANCE;

    private Client(String url) throws DeploymentException, IOException {
        sessions = ContainerProvider.getWebSocketContainer().connectToServer(this, URI.create(url));
    }

    public synchronized static boolean connect(String url) {
        try {
            INSTANCE = new Client(url);
            return true;
        } catch (DeploymentException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("连接成功!");
    }

    @OnMessage
    public void onMessage(String json) {
//        System.out.println(json);
        Message message = JSONObject.parseObject(json, Message.class);
        if ("message".equals(message.getPost_type())) {
            //确认是消息类型
            if ("975202851".equals(message.getGroup_id())) {
                //我们群
                if("1770390908".equals(message.getUser_id())){
                    if("setu".equals(message.getMessage())){
                        Request<Param> paramRequest = new Request<>();
                        paramRequest.setAction("send_group_msg");
                        Param param = new Param();
                        param.setGroup_id(message.getGroup_id());
                        param.setMessage("色图功能尚未实现，尽请期待!");
                        param.setMessage_type("group");
                        param.setAuto_escape(true);
                        paramRequest.setParams(param);
                        sendMessage(JSON.toJSONString(paramRequest));
                    }else {
                        Request<Param> paramRequest = new Request<>();
                        paramRequest.setAction("send_group_msg");
                        Param param = new Param();
                        param.setGroup_id(message.getGroup_id());
                        param.setMessage(message.getMessage());
                        param.setMessage_type("group");
                        param.setAuto_escape(true);
                        paramRequest.setParams(param);
                        sendMessage(JSON.toJSONString(paramRequest));
                    }

                }
            }
        } else {
            System.out.println("此次不为消息收发!");
        }
    }


    @OnClose
    public void onClose(Session session) {
        System.out.println("连接关闭");
    }

    @OnError
    public void OnError(Session session, Throwable throwable) {
        System.out.println("连接异常");
    }

    public static void sendMessage(String json) {
        Client.INSTANCE.sessions.getAsyncRemote().sendText(json);
    }
}
