package com.example.old_age_paradise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Admin extends AppCompatActivity {
    private ListView listView_for_food_order;
    private List<Food_order_data_handle> food_order_list;
    private Adapter_foodOrderfetch_List adapter_foodOrderfetch_list;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        databaseReference = FirebaseDatabase.getInstance().getReference("Food_Order");

        food_order_list = new ArrayList<>();
        adapter_foodOrderfetch_list = new Adapter_foodOrderfetch_List(Admin.this,food_order_list);
        listView_for_food_order = findViewById(R.id.listview_food_order);
    }

    @Override
    protected  void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                food_order_list.clear();
                for(DataSnapshot dataSnapshot1 : datasnapshot.getChildren()){

                    Food_order_data_handle food_order_data_handle = dataSnapshot1.getValue(Food_order_data_handle.class);
                    food_order_list.add(food_order_data_handle);

                }

                listView_for_food_order.setAdapter(adapter_foodOrderfetch_list);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();
    }
}