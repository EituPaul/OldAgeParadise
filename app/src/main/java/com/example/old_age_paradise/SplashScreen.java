package com.example.old_age_paradise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class  SplashScreen extends AppCompatActivity {

    //variable
    private static int SPLASH_SCREEN = 3000;
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full activity code
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        //setting animation time
        topAnim.setDuration(2000);
        bottomAnim.setDuration(2000);

        //find the widget of splash screen by id
        image=(ImageView) findViewById(R.id.imageView);
        textView =(TextView)findViewById(R.id.textView);

        //setting animation element
        image.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);

        //after animation end
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(getApplicationContext(),LogInActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}