package com.example.old_age_paradise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {

    //variable
    public EditText signInEmailEditText, signInPasswordEditext;
    public Button signInButton,SignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //finding by id
        signInEmailEditText = (EditText) findViewById(R.id.useremailsignIn);
        signInPasswordEditext = (EditText) findViewById(R.id.passwordsignIn);
        signInButton = (Button)findViewById(R.id.login);
        SignUpButton = (Button)findViewById(R.id.SignUpLogIn);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ii);
            }
        });
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(ii);
            }
        });

    }
}