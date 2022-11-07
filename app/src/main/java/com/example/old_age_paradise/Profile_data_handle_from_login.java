package com.example.old_age_paradise;

public class Profile_data_handle_from_login {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email,password;

    public Profile_data_handle_from_login(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
