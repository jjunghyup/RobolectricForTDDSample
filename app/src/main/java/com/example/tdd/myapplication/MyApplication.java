package com.example.tdd.myapplication;

import android.app.Application;

/**
 * Created by cholong on 16. 3. 26..
 */
public class MyApplication extends Application {
    public LoginHandler getLoginHandler() {
        return new LoginHandler();
    }
}
