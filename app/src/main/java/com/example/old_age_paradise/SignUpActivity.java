
package com.example.old_age_paradise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class  SignUpActivity extends AppCompatActivity {

    //variable
    public EditText signUpUserNameEditText, signUpEmailEditText, signUpPasswordEditext,
            signUpConfirmPasswordEditext;
    public Button signupButton;
    public ProgressBar signUpprogress;
    public FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        //finding by id
        signUpEmailEditText = (EditText) findViewById(R.id.signUpuseremail);
        signUpprogress = (ProgressBar) findViewById(R.id.signUploading);
        signUpPasswordEditext = (EditText) findViewById(R.id.signUppassword);
        signupButton = (Button) findViewById(R.id.SignUpButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
//             for a new register
                    case R.id.SignUpButton:
                        newusersignUp();
//                        Intent ii1 = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(ii1);
                        break;


                }

            }
        });

    }
//        signupButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                switch (v.getId())
////                {
////                 //for a new register
////                    case R.id.SignUpButton:
//                           //newusersignUp();
//                        Intent ii1 = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(ii1);
////                   break;
////                }
//            }
//        });


        private void newusersignUp(){

            String email = signUpEmailEditText.getText().toString().trim();
            String password = signUpPasswordEditext.getText().toString().trim();

            //checking email is empty or not
            if (email.isEmpty()) {
                signUpEmailEditText.setError("Enter an email address");
                signUpEmailEditText.requestFocus();
                return;
            }

            // check email is valid or not>
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                signUpEmailEditText.setError("Enter a valid email address");
                signUpEmailEditText.requestFocus();
                return;
            }
            //check password is empty or not?
            if (password.isEmpty()) {
                signUpPasswordEditext.setError("Enter a password");
                signUpPasswordEditext.requestFocus();
                return;
            }
            if (password.length() < 6) {
                signUpPasswordEditext.setError("Minimum password length should be 6");
                signUpPasswordEditext.requestFocus();
                return;
            }

            signUpprogress.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    signUpprogress.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Register is Succesful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Register is not Succesful", Toast.LENGTH_LONG).show();

                    }
                }
            });


        }
    }
