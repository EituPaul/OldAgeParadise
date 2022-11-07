package com.example.old_age_paradise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request =(Button) findViewById(R.id.request_any_service);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Services.class);
                startActivity(intent);
            }
        });
    }

    @Override//menu introduced to java file
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);


    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id =item.getItemId();
        if(id==R.id.ID_Services)
        {
            Intent intent = new Intent(MainActivity.this,Services.class);
            startActivity(intent);

        }
        if(id==R.id.about_us)
        {
            Intent intent = new Intent(MainActivity.this,About_Us.class);
            startActivity(intent);

        }
        if(id==R.id.contact)
        {
            Intent intent = new Intent(MainActivity.this,Contact_us.class);
            startActivity(intent);

        }
        if(id==R.id.rate_us)
        {
            Intent intent = new Intent(MainActivity.this,Rate_Us.class);
            startActivity(intent);

        }
        if(id==R.id.profile)
        {
            Intent intent = new Intent(MainActivity.this,Profile.class);
            startActivity(intent);

        }
        if(id==R.id.admin)
        {
            Intent intent = new Intent(MainActivity.this,CheckAdmin.class);
            startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }



}
