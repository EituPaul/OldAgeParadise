package com.example.old_age_paradise;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.ktx.Firebase;


public class Rate_Us extends AppCompatActivity {
    long star1=0,star2=0,star3=0,star4=0,star5=0,count=0;double avgrate;
    EditText email,send_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        email = findViewById(R.id.email);
        send_message =findViewById((R.id.sendmessage));
        RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.simpleRatingBar);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        Button see_feedback_Button = (Button) findViewById(R.id.see_feedBackButton);





    }
}