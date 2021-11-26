package com.example.propertymanager.Model;

public class Room {
    private  int rooom_id;
    private String room_name;
    private String room_desc;

    public Room(String room_name, String room_desc) {
        this.room_name = room_name;
        this.room_desc = room_desc;
    }

    public Room(int rooom_id, String room_name, String room_desc) {
        this.rooom_id = rooom_id;
        this.room_name = room_name;
        this.room_desc = room_desc;
    }

    public int getRooom_id() {
        return rooom_id;
    }

    public void setRooom_id(int rooom_id) {
        this.rooom_id = rooom_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_desc() {
        return room_desc;
    }

    public void setRoom_desc(String room_desc) {
        this.room_desc = room_desc;
    }
}
