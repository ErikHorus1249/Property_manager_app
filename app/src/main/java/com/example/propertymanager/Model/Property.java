package com.example.propertymanager.Model;

public class Property {
    private  int pro_id;
    private  String pro_name;
    private String pro_type;
    private  String pro_price;
    private  int pro_pos;

    public Property(int pro_id, String pro_name, String pro_type, String pro_price, int pro_pos) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_type = pro_type;
        this.pro_price = pro_price;
        this.pro_pos = pro_pos;
    }

    public Property(String pro_name, String pro_type, String pro_price, int pro_pos) {
        this.pro_name = pro_name;
        this.pro_type = pro_type;
        this.pro_price = pro_price;
        this.pro_pos = pro_pos;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_type() {
        return pro_type;
    }

    public void setPro_type(String pro_type) {
        this.pro_type = pro_type;
    }

    public String getPro_price() {
        return pro_price;
    }

    public void setPro_price(String pro_price) {
        this.pro_price = pro_price;
    }

    public int getPro_pos() {
        return pro_pos;
    }

    public void setPro_pos(int pro_pos) {
        this.pro_pos = pro_pos;
    }
}

