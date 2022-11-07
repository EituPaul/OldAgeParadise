package com.example.old_age_paradise;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> list;
    Context context;

    public  MyAdapter(Context context,ArrayList<Model> list)
    {
        this.list=list;
        this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Model model= list.get(position);
        holder.Email.setText(model.getEmail());

        holder.Feedback.setText(model.getFeedback());


        holder.Rating.setText(model.getRating());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Email,Feedback,Rating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           Email = itemView.findViewById(R.id.email_text);
           Feedback =itemView.findViewById(R.id.message_text);
           Rating =itemView.findViewById(R.id.rating_);

        }
    }
}
