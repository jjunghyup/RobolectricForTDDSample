package com.example.tdd.myapplication;

import android.widget.Button;
import android.widget.TextView;

import com.example.tdd.runner.CustomGradleTestRunner;
import com.example.tdd.shadow.ShadowLoginHandler;

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
@RunWith(CustomGradleTestRunner.class)
@Config(constants = BuildConfig.class, shadows = {ShadowLoginHandler.class})
public class MyActivityTest {
    MyActivity activity;

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
        Button loginButton = (Button) activity.findViewById(R.id.main_loginButton);
        TextView view = (TextView) activity.findViewById(R.id.main_resultView);
        System.out.println(ShadowLoginHandler.class.getCanonicalName());

        loginButton.performClick();

        assertEquals("OK", view.getText());
    }


}
