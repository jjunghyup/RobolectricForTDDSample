package com.example.tdd.myapplication;

/**
 * Created by cholong on 16. 3. 19..
 */
public class LoginHandler {

    private String resultMessage;

    public void login(String id, String pw) {
        resultMessage = "OK";
    }

    public String getResult(){
        return this.resultMessage;
    }
}
