package com.example.old_age_paradise;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class Rate_Us extends AppCompatActivity {
    double count=0.0,count2;double avgrate=0.0 ,avgrate2;long avgrate3;
    EditText email,send_message;
    RatingBar simpleRatingBar;
    Button submitButton;
    Button see_feedback_Button,see_avgrating_button;
    ProgressBar rate_progressbar,progress_Bar;
    TextView show_rating;

    private FirebaseDatabase get_rating_feedback_database = FirebaseDatabase.getInstance();
    private DatabaseReference root = get_rating_feedback_database.getReference().child("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        email = findViewById(R.id.email);
        send_message =findViewById((R.id.sendmessage));
        simpleRatingBar = (RatingBar) findViewById(R.id.simpleRatingBar);
        submitButton = (Button) findViewById(R.id.submitButton);
        see_avgrating_button =(Button) findViewById(R.id.see_avg_rating);
        see_feedback_Button = (Button) findViewById(R.id.see_feedBackButton);
        rate_progressbar = findViewById(R.id.signUploading);
        progress_Bar = findViewById(R.id.progressBar);




        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate_progressbar.setVisibility(View.VISIBLE);
                //rating value get
                String emailId = email.getText().toString().trim();
                String sendMessage = send_message.getText().toString().trim();

                String rating =String.valueOf(simpleRatingBar.getRating());


                //checking email is empty or not
                if (emailId.isEmpty()) {
                    //rate_progressbar.setVisibility(View.GONE);
                    email.setError("Enter an email address");
                    email.requestFocus();

                    return;
                }

                // check email is valid or not>
                if (!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
                    //rate_progressbar.setVisibility(View.GONE);
                    email.setError("Enter a valid email address");
                    email.requestFocus();

                    return;
                }


                //hashmap diye data pathale key diye pathano jabe
                HashMap<String,String> userMap = new HashMap<>();
                userMap.put("Email",emailId);
                userMap.put("Feedback",sendMessage);
                userMap.put("Rating",rating);
                //push use korle protibar data set korar somoy unique key diye set hobe
                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        rate_progressbar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Your response is taken", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_LONG).show();

                        }
                    }
                });



//                if(root.push().setValue(userMap) != null) {
//                   // rate_progressbar.setVisibility(View.GONE);
//                    final ProgressDialog dialog = new ProgressDialog(Rate_Us.this);
//                    Dialog dialog1 = new Dialog(Rate_Us.this);
//                   // dialog.setTitle("Loading...");
//                    dialog.setMessage("Please wait.");
//
//                   // Toast.makeText(getApplicationContext(), "Your response is  collected", Toast.LENGTH_LONG).show();
//                    dialog.setIndeterminate(true);
//                    dialog.setCancelable(false);
//                    dialog.show();
//
//                    long delayInMillis = 2000;
//                    Timer timer = new Timer();
//                    timer.schedule(new TimerTask() {
//                        @Override
//                        public void run() {
//
//                            dialog.setMessage("Your response is taken");
//
//                            long delayInMillis2 = 800;
//
//                            //inner
//                            Timer timer2  = new Timer();
//                            timer2.schedule(new TimerTask() {
//                                               @Override
//                                               public void run() {
//                                                   dialog.dismiss();
//                                               }
//                                           }, delayInMillis2
//                            );
//
//
//
//
//
//
//                        }
//                    }, delayInMillis
//                    );
//
//
//
//
//
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "Your response is not collected", Toast.LENGTH_LONG).show();
//                }


            }
        });

        see_avgrating_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progress_Bar.setVisibility(View.VISIBLE);
             root.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                     avgrate=0.0;
                     count =0.0;
                     for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                         count++;
                         String fetch_rating=snapshot.child(("Rating")).getValue().toString().trim();
                         double fetch_rating_double =Double.parseDouble(fetch_rating);
                         avgrate =avgrate + fetch_rating_double;
                     }


                     avgrate2 =((avgrate)/count);


                     String str = String.valueOf(avgrate2);
                     //show_rating.setText(str);
                     progress_Bar.setMax(5);
                     progress_Bar.setProgress((int) avgrate2);

                     Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();


                 }


                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                 }

             });



            }
        });


         see_feedback_Button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 final ProgressDialog dialog = new ProgressDialog(Rate_Us.this);

                    dialog.setTitle("Loading...");
                    dialog.setMessage("Please wait.");
                    dialog.setIndeterminate(true);
                    dialog.setCancelable(false);
                    dialog.show();

                    long delayInMillis = 2000;
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            dialog.dismiss();

                        }
                    }, delayInMillis
                    );
                 runthread();

                 Intent i1= new Intent(getApplicationContext(),Feedbacks.class);
                 startActivity(i1);



             }
         });
    }
//next window te jawar jnno wait korbe ei time porjnto;
    private void runthread() {

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}