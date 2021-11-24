package com.example.propertymanager;

public class Property {
    private  String pro_name;
    private String pro_type;
    private  String pro_price;
    private  String pro_pos;

    public Property(String pro_name, String pro_type, String pro_price, String pro_pos) {
        this.pro_name = pro_name;
        this.pro_type = pro_type;
        this.pro_price = pro_price;
        this.pro_pos = pro_pos;
    }

    public String getPro_name() {
        return pro_name;
    }

    public String getPro_type() {
        return pro_type;
    }

    public String getPro_price() {
        return pro_price;
    }

    public String getPro_pos() {
        return pro_pos;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public void setPro_type(String pro_type) {
        this.pro_type = pro_type;
    }

    public void setPro_price(String pro_price) {
        this.pro_price = pro_price;
    }

    public void setPro_pos(String pro_pos) {
        this.pro_pos = pro_pos;
    }
}
