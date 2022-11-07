package com.example.old_age_paradise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class food_choice extends AppCompatActivity {

    Button order_food,back;
    EditText vname,vemail,vcontact,vaddress,vitem_name,vquantity,vend_date,vendtime;
    DatabaseReference databaseReference;


     DatabaseReference reference;
     String get_email_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_choice);
        databaseReference = FirebaseDatabase.getInstance().getReference("Food_Order");
        reference = FirebaseDatabase.getInstance().getReference().child("Profile");

        back =findViewById(R.id.food_back);
        order_food =findViewById(R.id.food_order);
        vname =  findViewById(R.id.name);
        vemail =  findViewById(R.id.email);
        vcontact =  findViewById(R.id.contact);
        vaddress =  findViewById(R.id.address);
        vitem_name =  findViewById(R.id.item_name);
        vquantity =  findViewById(R.id.item_quantity);
        vend_date =  findViewById(R.id.item_date);
        vendtime =  findViewById(R.id.item_time);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(food_choice.this,Services.class);
                startActivity(intent);
            }
        });

        order_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });


    }
    public void saveData()

    {   //user_email fetch from profile code

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for(DataSnapshot snapshot : datasnapshot.getChildren()){
                    String ma = snapshot.child("email").getValue().toString();
                      get_email_profile =ma;



                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //end_user_email code from profile code
        String name = vname.getText().toString().trim();
        vemail.setText(get_email_profile);
        String email = vemail.getText().toString().trim();

        String contact = vcontact.getText().toString().trim();
        String address = vaddress.getText().toString().trim();
        String item = vitem_name.getText().toString().trim();
        String quantity = vquantity.getText().toString().trim();
        String end_date = vend_date.getText().toString().trim();
        String end_time = vendtime.getText().toString().trim();
        //checking email is empty or not
        if (email.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vemail.setError("Enter an email address");
            vemail.requestFocus();

            return;
        }

        // check email is valid or not>
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //rate_progressbar.setVisibility(View.GONE);
            vemail.setError("Enter a valid email address");
            vemail.requestFocus();

            return;
        }
        if (name.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vname.setError("Enter Your name!");
            vname.requestFocus();

            return;
        }
        if (contact.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vcontact.setError("Enter Your Contact!");
            vcontact.requestFocus();

            return;
        }
        if (address.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vaddress.setError("Enter Your address!");
            vaddress.requestFocus();

            return;
        }
        if (item.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vitem_name.setError("Enter  item name!");
            vitem_name.requestFocus();

            return;
        }
        if (address.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vaddress.setError("Enter Your address!");
            vaddress.requestFocus();

            return;
        }
        if (quantity.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vquantity.setError("Enter the quantity!");
            vquantity.requestFocus();

            return;
        }
        if (end_date.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vend_date.setError("Enter the date!");
            vend_date.requestFocus();

            return;
        }
        if (end_time.isEmpty()) {
            //rate_progressbar.setVisibility(View.GONE);
            vendtime.setError("Enter Your item!");
            vendtime.requestFocus();

            return;
        }






        String key =databaseReference.push().getKey();
        Food_order_data_handle food_order_data_handle = new Food_order_data_handle(name,email,contact,address,item,quantity,end_date,end_time);

        databaseReference.child(key).setValue(food_order_data_handle);
        final ProgressDialog dialog = new ProgressDialog(food_choice.this);

        dialog.setTitle("Please wait...");
        dialog.setMessage("You order has been taken");
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
        // Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();

    }

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