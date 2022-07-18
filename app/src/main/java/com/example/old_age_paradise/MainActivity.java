package com.example.old_age_paradise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if(id==R.id.rate_us)
        {
            Intent intent = new Intent(MainActivity.this,Rate_Us.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

}