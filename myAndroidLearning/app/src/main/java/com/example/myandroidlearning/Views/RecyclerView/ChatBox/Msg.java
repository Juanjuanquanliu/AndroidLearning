package com.example.myandroidlearning.Views.RecyclerView.ChatBox;

import java.util.ArrayList;
import java.util.List;

public class Msg {
    public static final int TYPE_RECEVIED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;

    public String getContent() {
        return content;
    }

    public int getTyoe() {
        return type;
    }


    public Msg(String content, int type){
        this.content = content;
        this.type = type;
    }


    public static List<Msg> initMsgFruits(){
        List<Msg> MsgList = new ArrayList<>();
        Msg holder = new Msg( "Hello, how are you?",Msg.TYPE_RECEVIED);
        MsgList.add(holder);
        holder = new Msg( "Hello, I'm fine, thank you. And you?",Msg.TYPE_SENT);
        MsgList.add(holder);
        holder = new Msg( "Well, I'm ok, too.",Msg.TYPE_RECEVIED);
        MsgList.add(holder);
        holder = new Msg( "Ok, bye~",Msg.TYPE_SENT);
        MsgList.add(holder);

        return  MsgList;

    }
}
