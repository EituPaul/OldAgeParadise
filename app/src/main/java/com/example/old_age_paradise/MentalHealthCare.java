package com.example.old_age_paradise;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MentalHealthCare extends AppCompatActivity {

    RadioButton Rd1, Rd2, Rd3, Rd4, Rd5, Rd6, Rd7, Rd8, RdNO1, RdNO2, RdNO3, RdNO4, RdNO5,
            RdNO6, RdNO7, RdNO8;
    Button mentalHealthSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_care);
        Rd1 = findViewById(R.id.gameRd1);
        Rd2 = findViewById(R.id.gameRd2);
        Rd3 = findViewById(R.id.gameRd3);
        Rd4 = findViewById(R.id.gameRd4);
        Rd5 = findViewById(R.id.gameRd5);
        Rd6 = findViewById(R.id.gameRd6);
        Rd7 = findViewById(R.id.gameRd7);
        Rd8 = findViewById(R.id.gameRd8);
        RdNO1 = findViewById(R.id.notSelect1);
        RdNO2 = findViewById(R.id.notSelect2);
        RdNO3 = findViewById(R.id.notSelect3);
        RdNO4 = findViewById(R.id.notSelect4);
        RdNO5 = findViewById(R.id.notSelect5);
        RdNO6 = findViewById(R.id.notSelect6);
        RdNO7 = findViewById(R.id.notSelect7);
        RdNO8 = findViewById(R.id.notSelect8);
        mentalHealthSubmitBtn = findViewById(R.id.mentalHealthSubmitBtn);
        mentalHealthSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int counterGameAddict = 0, selectedNo = 0;
//count yes button
                if (Rd1.isChecked()) {
                    counterGameAddict++;
                }
                if (Rd2.isChecked()) {
                    counterGameAddict++;
                }
                if (Rd3.isChecked()) {
                    counterGameAddict++;
                }
                if (Rd4.isChecked()) {
                    counterGameAddict++;
                }
                if (Rd5.isChecked()) {
                    counterGameAddict++;
                }
                if (Rd6.isChecked()) {
                    counterGameAddict++;
                }
                if (Rd7.isChecked()) {
                    counterGameAddict++;
                }
                if (Rd8.isChecked()) {
                    counterGameAddict++;
                }
                //select No
                if (RdNO1.isChecked()) {
                    selectedNo++;
                }
                if (RdNO2.isChecked()) {
                    selectedNo++;
                }
                if (RdNO3.isChecked()) {
                    selectedNo++;
                }
                if (RdNO4.isChecked()) {
                    selectedNo++;
                }
                if (RdNO5.isChecked()) {
                    selectedNo++;
                }
                if (RdNO6.isChecked()) {
                    selectedNo++;
                }
                if (RdNO7.isChecked()) {
                    selectedNo++;
                }
                if (RdNO8.isChecked()) {
                    selectedNo++;
                }
                if((counterGameAddict+selectedNo)<8){
                    Toast.makeText(getApplicationContext(),"Select all the options",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(counterGameAddict>=4){

                        Intent intent = new Intent(MentalHealthCare.this,
                                ConsultPhysiatrist.class);
                        //intent.putExtra("addiction","game");
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Intent intent = new Intent(MentalHealthCare.this, NoNeedPhychiatrist.class);
                        //intent.putExtra("addiction","game");
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
}