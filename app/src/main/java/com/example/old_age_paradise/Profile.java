package com.example.old_age_paradise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;

public class Profile<img_str> extends AppCompatActivity {

    // One Button
    Button BSelectImage;

    // One Preview Image
    ImageView IVPreviewImage;

    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;
    EditText profile_email,profile_password;
    Button vgo_to_home;
    CheckBox vcheckbox;

    //backendpart

    DatabaseReference reference;

    //endbackend

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences preferences = getSharedPreferences("myprefs",MODE_PRIVATE);
        BSelectImage = findViewById(R.id.BSelectImage);
        IVPreviewImage = findViewById(R.id.IVPreviewImage);
        profile_email = findViewById(R.id.emailprofile);
        profile_password = findViewById(R.id.password_profile);
        vgo_to_home = findViewById(R.id.go_to_home);
       vcheckbox  = findViewById(R.id.checkbox);

       //backend
        reference = FirebaseDatabase.getInstance().getReference().child("Profile");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

              for(DataSnapshot snapshot : datasnapshot.getChildren()){
                  String ma = snapshot.child("email").getValue().toString();
                  profile_email.setText(ma);
                  String ma1 = snapshot.child("password").getValue().toString();
                  profile_password.setText(ma1);


              }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        //endbackend


        // handle the Choose Image button to trigger
        // the image chooser function
        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        vgo_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


        //password show
        vcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked) {
                    // show password
                    profile_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    profile_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
         //end password show
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }


}