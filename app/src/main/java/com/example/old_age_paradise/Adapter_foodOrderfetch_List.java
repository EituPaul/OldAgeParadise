package com.example.old_age_paradise;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter_foodOrderfetch_List extends ArrayAdapter<Food_order_data_handle> {
    private Activity context;
    private List<Food_order_data_handle > food_order_list;

    public Adapter_foodOrderfetch_List( Activity context,  List<Food_order_data_handle>food_order_list) {
        super(context,R.layout.food_order_data_fetch_item,food_order_list );
        this.context = context;
        this.food_order_list = food_order_list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater =context.getLayoutInflater();
       View view = layoutInflater.inflate(R.layout.food_order_data_fetch_item,null,true);


       Food_order_data_handle food_order_data_handle = food_order_list.get(position);
        TextView name=view.findViewById(R.id.user_name_item);
        TextView email=view.findViewById(R.id.user_email_item);
        TextView contact=view.findViewById(R.id.contact_item);
        TextView address=view.findViewById(R.id.address_item);
        TextView item=view.findViewById(R.id.itemname_item);
        TextView quantity=view.findViewById(R.id.item_quantity);
        TextView end_date=view.findViewById(R.id.item_date);
        TextView end_time=view.findViewById(R.id.item_time);

        return view;
    }
}

