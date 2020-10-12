package com.example.bme3890projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et_username;
    public static final String NAME_EXTRA = "com.example.bme3890projectapp.EXTRA.NAME";
    private EditText et_password;
    public String name;
    private android.widget.Button login;
    private android.widget.Button signUp;
    private TextView loginError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        login = (Button) findViewById(R.id.button_login);
        signUp = (Button) findViewById(R.id.button_signUp);
        loginError = (TextView) findViewById(R.id.tv_loginError);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(et_username.getText().toString(), et_password.getText().toString());
            }
        });

    }

    public void validate(String userName, String userPassword) {
        if ((userName.toUpperCase().equals("Christia".toUpperCase())) && (userPassword.equals("1234"))) {
            String name = et_username.getText().toString();
            Intent loginToApp = new Intent (MainActivity.this, SecondActivity.class);
            loginToApp.putExtra(NAME_EXTRA, name);
            startActivity(loginToApp);
        }
        else if (!(userName.toUpperCase().equals("Christia".toUpperCase())) && (userPassword.equals("1234"))) {
            loginError.setText("Username is incorrect.");
        }
        else if ((userName.toUpperCase().equals("Christia".toUpperCase())) && !(userPassword.equals("1234"))) {
            loginError.setText("Password is incorrect.");
        }
        else {
            loginError.setText("Username and password are incorrect.");
        }


    }

    public void forgotPassword(View view){
        Intent intent = new Intent(MainActivity.this, ForgotPassword.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);

    }
}
