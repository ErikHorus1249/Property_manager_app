package com.example.propertymanager.Model;

public class User {
    private int user_id;
    private String user_name;
    private String user_avt;
    private boolean user_mode;

    public User(int user_id, String user_name, String user_avt, boolean user_mode) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_avt = user_avt;
        this.user_mode = user_mode;
    }

    public User(String user_name, String user_avt, boolean user_mode) {
        this.user_name = user_name;
        this.user_avt = user_avt;
        this.user_mode = user_mode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avt() {
        return user_avt;
    }

    public void setUser_avt(String user_avt) {
        this.user_avt = user_avt;
    }

    public boolean isUser_mode() {
        return user_mode;
    }

    public void setUser_mode(boolean user_mode) {
        this.user_mode = user_mode;
    }
}
