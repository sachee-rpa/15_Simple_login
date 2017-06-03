package com.example.sachee.a15_simple_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public void LoginButton(){
        username = (EditText)findViewById(R.id.editText_name);
        password = (EditText)findViewById(R.id.editText_password);
        attempts = (TextView)findViewById(R.id.attemp);
        login_btn = (Button)findViewById(R.id.button);

        attempts.setText(Integer.toString((attempt_counter)));
    login_btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(username.getText().toString().equals("user") && password.getText().toString().equals("pass")){
                       Toast.makeText(Login.this,"User and Password is correct", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent("com.example.sachee.a15_simple_login.SeconActivity");
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Login.this,"User and Password is not correct", Toast.LENGTH_SHORT).show();
                        attempt_counter --;
                        attempts.setText(Integer.toString((attempt_counter)));
                        if(attempt_counter == 0){
                            login_btn.setEnabled(false);
                        }

                    }

                }

            }
    );

    }
}
