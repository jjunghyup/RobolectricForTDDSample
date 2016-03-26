package com.example.tdd.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by cholong on 16. 3. 19..
 */
public class MyActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText idEditText = (EditText) findViewById(R.id.main_id);
        final EditText pwEditText = (EditText) findViewById(R.id.main_pw);
        Button loginButton = (Button) findViewById(R.id.main_loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(
                        idEditText.getText().toString(),
                        pwEditText.getText().toString()
                );
            }
        });
    }

    private void login(String id, String pw) {
        LoginHandler loginHandler = getLoginHandler();
        loginHandler.login(id, pw);

        TextView view = (TextView)findViewById(R.id.main_resultView);
        view.setText(loginHandler.getResult());
    }

    private LoginHandler getLoginHandler() {
        MyApplication application = (MyApplication)getApplication();
        return application.getLoginHandler();
    }
}
