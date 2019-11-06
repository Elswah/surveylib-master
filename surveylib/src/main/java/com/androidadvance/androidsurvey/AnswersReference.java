package com.androidadvance.androidsurvey;

import com.google.gson.Gson;

import java.util.LinkedHashMap;

//Singleton AnswersReference ........

public class AnswersReference {
    private volatile static AnswersReference uniqueInstance;


    private final LinkedHashMap<String, String> answered_hashmap = new LinkedHashMap<>();
    private  String userName;
    private  String sessionId;


    private AnswersReference() {
    }

    public void put_answer(String key, String value) {
        answered_hashmap.put(key, value);
    }

    public void put_name(String userName, String sessionId) {
        this.userName=userName;
        this.sessionId = sessionId;
    }

    public String get_json_object() {
        Gson gson = new Gson();
        return gson.toJson(answered_hashmap,LinkedHashMap.class);
    }

    @Override
    public String toString() {
        return String.valueOf(answered_hashmap);
    }

    public static AnswersReference getInstance() {
        if (uniqueInstance == null) {
            synchronized (AnswersReference.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new AnswersReference();
                }
            }
        }
        return uniqueInstance;
    }


}
