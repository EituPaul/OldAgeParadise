package com.example.old_age_paradise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Feedbacks extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseDatabase get_rating_feedback_database = FirebaseDatabase.getInstance();
    private DatabaseReference root = get_rating_feedback_database.getReference().child("Users");
    DatabaseReference database;
    private MyAdapter adapter;
    private ArrayList<Model>list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbacks);

        recyclerView = findViewById(R.id.recyclerview);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter =new MyAdapter(this,list);

        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                   Model model = dataSnapshot.getValue(Model.class);

                    list.add(model);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}