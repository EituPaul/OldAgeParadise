package com.example.old_age_paradise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Contact_us extends AppCompatActivity {
    ImageView vcall1,vcall2,vsms1,vsms2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        vcall1 =findViewById(R.id.call1);
        vcall2 =findViewById(R.id.call2);
       vsms1=findViewById(R.id.sms1);
        vsms2=findViewById(R.id.sms2);


        vcall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+ "01827720765"));
                startActivity(i);
            }
        });
        vcall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+ "01887945430"));
                startActivity(i);
            }
        });
    }
}