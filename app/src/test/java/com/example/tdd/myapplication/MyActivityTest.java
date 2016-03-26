package com.example.tdd.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tdd.runner.CustomGradleTestRunner;
import com.example.tdd.shadow.ShadowLoginHandler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Created by cholong on 16. 3. 19..
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
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

    @Test
    public void testNextActivity(){
        Button nextButton = (Button) activity.findViewById(R.id.main_nextActivity);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, NextActivity.class);
                activity.startActivity(intent);
            }
        });

        nextButton.performClick();
        Intent nextActivityIntent = Shadows.shadowOf(activity).getNextStartedActivity();
        assertEquals(NextActivity.class.getName(), nextActivityIntent.getComponent().getClassName());

    }


}
