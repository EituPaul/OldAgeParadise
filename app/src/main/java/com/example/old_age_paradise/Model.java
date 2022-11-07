package com.example.old_age_paradise;
//model class for feedback
public class Model {

    String Email, Rating;
    private String Feedback;




    public String getEmail(){
       return Email;
    }

    public String getFeedback(){
        return Feedback;
    }
    //setter method use na korle jhamela
    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public String getRating(){
        return Rating;
    }

}
