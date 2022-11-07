package com.example.old_age_paradise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Request_Medical_Service extends AppCompatActivity implements View.OnClickListener {
    Button requestServiceBackButton, requestServiceNextButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_medical_service_form);

        requestServiceBackButton = findViewById(R.id.request_service_back_button);
        requestServiceNextButton = findViewById(R.id.request_service_next_button);

        requestServiceBackButton.setOnClickListener(this);
        requestServiceNextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.request_service_back_button){
            Intent intent = new Intent(Request_Medical_Service.this, Services.class);
            startActivity(intent);
        }if(v.getId()==R.id.request_service_next_button){
            Intent intent = new Intent(Request_Medical_Service.this, Services.class);
            startActivity(intent);
        }


    }
}