package com.makeveryday.ahnjunhyeock.juntalk.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahnjunhyeock on 2017. 12. 30..
 */

public class ChatModel {

    public Map<String, Boolean> users = new HashMap<>();
    public Map<String, Comment> comments = new HashMap<>();

    public static class Comment {

        public String uid;
        public String message;
        public Object timeStamp;
        public Map<String, Object> readUsers = new HashMap<>();

    }


}
