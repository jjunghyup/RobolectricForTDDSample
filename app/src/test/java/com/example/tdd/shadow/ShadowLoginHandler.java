package com.example.tdd.shadow;

import com.example.tdd.myapplication.LoginHandler;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

/**
 * Created by cholong on 16. 3. 26..
 */
@Implements(LoginHandler.class)
public class ShadowLoginHandler {

    @Implementation
    public String getResult() {
        return "Fail";
    }
}
