package com.example.old_age_paradise;

public class Food_order_data_handle {

    private String name,email,contact,address,item,quantity,end_date,end_time;
    //add_for_listview
   public Food_order_data_handle()
   {

   }
    //end_for_listview

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food_order_data_handle(String name, String email, String contact, String address, String item , String quantity, String end_date, String end_time) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address =address;
        this.item = item;
        this.quantity =quantity;
        this.end_date = end_date;
        this.end_time = end_time;
    }


}
