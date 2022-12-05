package com.itheima.reggie.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.entity.colorCounter;
import com.itheima.reggie.service.ColorCounterService;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.util.List;


/**
 *  websocket客户端监听类 ws://172.21.12.73/ws/emosweb CCR 输送
 * @author 。
 */
public class MyWebSocketClient extends WebSocketClient {
   public String color1;
   public String color2;

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);

    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println(">>>>>>>>>>>websocket open");


        JSONObject object = new JSONObject();
        object.put("id", "");
        object.put("type", "general");
        object.put("key", "userActivityStatues");
        object.put("value", "ACTIVE");
        this.send(object.toJSONString());

        object.clear();
        object.put("id", "7");
        object.put("type", "advise");
        object.put("plc", "L3F07");
        object.put("tag", ".L3F07_DecPoint_TC400.Row[1,2].AS.I9999_Filtr03");

        this.send(object.toJSONString());
        object.clear();
        object.put("id", "9");
        object.put("type", "advise");
        object.put("plc", "L3F07");
        object.put("tag", ".L3F07_DecPoint_TC400.Row[1,1].AS.I9999_Filtr03");

        this.send(object.toJSONString());
        object.clear();
        object.put("id", "11");
        object.put("type", "poke");
        object.put("plc", "L3F07");
        object.put("tag", ".L3F07_DecPoint_TC400.Row[1,1].AS.I9999_Filtr03");
        object.put("value", this.color1);

        this.send(object.toJSONString());
        object.clear();
        object.put("id", "10");
        object.put("type", "poke");
        object.put("plc", "L3F07");
        object.put("tag", ".L3F07_DecPoint_TC400.Row[1,2].AS.I9999_Filtr03");
        object.put("value", this.color2);
        this.send(object.toJSONString());
        object.clear();
    }

    @Override
    public void onMessage(String s) {
        System.out.println(s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println(">>>>>>>>>>>websocket close");
    }

    @Override
    public void onError(Exception e) {

    }


}