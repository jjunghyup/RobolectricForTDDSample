package com.example.tdd.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Created by cholong on 16. 3. 19..
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MyActivityTest {
    MyActivity activity;
    LoginHandler loginHandler;
    @Before
    public void setup(){
        activity = Robolectric.buildActivity(MyActivity.class).create().get();
    }

    @Test
    public void test(){
        String appName = activity.getResources().getString(R.string.app_name);
        assertEquals("Robolectric Sample", appName);
    }

    @Test
    public void testLogin(){
        final EditText idEditText = (EditText) activity.findViewById(R.id.main_id);
        final EditText pwEditText = (EditText) activity.findViewById(R.id.main_pw);
        Button loginButton = (Button) activity.findViewById(R.id.main_loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(
                        idEditText.getText().toString(),
                        pwEditText.getText().toString()
                );
            }
        });

        idEditText.setText("id");
        pwEditText.setText("id");

        loginButton.performClick();

    }

    private void login(String id, String pw) {
        loginHandler.login(id,pw);
    }

}
