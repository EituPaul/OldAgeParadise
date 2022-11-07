package com.example.old_age_paradise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CheckAdmin extends AppCompatActivity {


    String password_edittext;
    String admin_password= "123456";
    EditText enter_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_admin);


        enter_password = findViewById(R.id.admin_password_edittext);
        Button vadmin_verify_password_btn = findViewById(R.id.admin_verify_password_btn);


        vadmin_verify_password_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                password_edittext=  enter_password.getText().toString().trim();
              if(password_edittext.equals(admin_password))
              {
                  Intent intent = new Intent(getApplicationContext(),Admin_See_Orders.class);
                  startActivity(intent);
              }
            else
              {
                  Toast.makeText(getApplicationContext(),"Please enter correct password",Toast.LENGTH_LONG).show();
              }

            }
        });
    }
}