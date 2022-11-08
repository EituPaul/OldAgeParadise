package com.example.old_age_paradise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Services extends AppCompatActivity implements View.OnClickListener{

    CardView Health_care_card,entertainment_card,food_card,mental_health_card;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Health_care_card = findViewById(R.id.Health_care);
        entertainment_card = findViewById(R.id.Entertainment);
        food_card = findViewById(R.id.food_service);
        mental_health_card = findViewById(R.id.Counselling);

        mental_health_card.setOnClickListener(this);
        Health_care_card.setOnClickListener(this);
        food_card.setOnClickListener(this);
        entertainment_card.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.Health_care)
        {
            Intent intent = new Intent(Services.this, MedicalForm.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.Entertainment)
        {
            Intent intent = new Intent(Services.this, Request_Medical_Service.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.food_service)
        {
            Intent intent = new Intent(Services.this, food_choice.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.Counselling)
        {
            Intent intent = new Intent(Services.this, MentalHealthCare.class);
            startActivity(intent);
        }


    }
}