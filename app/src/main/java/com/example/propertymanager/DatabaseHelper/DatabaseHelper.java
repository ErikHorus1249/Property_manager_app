package com.example.propertymanager.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.propertymanager.Model.Property;
import com.example.propertymanager.Model.Room;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final  String DATABASE_NAME = "B17DCAT008.property_manager";
    private static final  String PROPERTY_TABLE_NAME = "property";
    private static final  String ROOM_TABLE_NAME = "room";
    private static final  String USER_TABLE_NAME = "room";
    private static final  String PROPERTY_ID_COL = "id";
    private static final  String PROPERTY_NAME_COL = "name";
    private static final  String PROPERTY_TYPE_COL = "type";
    private static final  String PROPERTY_PRICE_COL = "price";
    private static final  String PROPERTY_POSITION_COL = "position";
    private static final  String ROOM_ID_COL = "id";
    private static final  String ROOM_NAME_COL = "name";
    private static final  String ROOM_DESCRIPTION_COL = "description";
    private static final  String USER_ID_COL = "id";
    private static final  String USER_NAME_COL = "name";
    private static final  String USER_AVT_COL = "avatar";
    private static final  String USER_MODE_COL = "mode";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_property = "CREATE TABLE IF NOT EXISTS "+ PROPERTY_TABLE_NAME +" ( "+
                PROPERTY_ID_COL + " INTEGER PRIMARY KEY  AUTOINCREMENT , "+
                PROPERTY_NAME_COL + " TEXT , "+
                PROPERTY_TYPE_COL + " TEXT , "+
                PROPERTY_PRICE_COL + " TEXT , "+
                PROPERTY_POSITION_COL + " INTEGER )";

        String create_room = "CREATE TABLE IF NOT EXISTS "+ ROOM_TABLE_NAME +" ( "+
                ROOM_ID_COL + " INTEGER PRIMARY KEY  AUTOINCREMENT , "+
                ROOM_NAME_COL + " TEXT , "+
                ROOM_DESCRIPTION_COL + " TEXT )";

        String create_user = "CREATE TABLE IF NOT EXISTS "+ USER_TABLE_NAME +" ( "+
                USER_ID_COL + " INTEGER PRIMARY KEY  AUTOINCREMENT , "+
                USER_NAME_COL + " TEXT , "+
                USER_AVT_COL + " TEXT , "+
                USER_MODE_COL + " BOOLEAN )";

        db.execSQL(create_property);
        db.execSQL(create_room);
        db.execSQL(create_user);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String delete_property = "DROP TABLE IF EXISTS "+PROPERTY_TABLE_NAME;
        String delete_room = "DROP TABLE IF EXISTS "+ROOM_TABLE_NAME;
        String delete_user = "DROP TABLE IF EXISTS "+USER_TABLE_NAME;

        onCreate(db);
    }

    public boolean add_property(Property property){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PROPERTY_NAME_COL, property.getPro_name());
        values.put(PROPERTY_TYPE_COL, property.getPro_type());
        values.put(PROPERTY_PRICE_COL, property.getPro_price());
        values.put(PROPERTY_POSITION_COL, property.getPro_pos());

        long check = db.insert(PROPERTY_TABLE_NAME, null, values );
        if(check!=-1) return  true;
        else  return false;
    }

    public ArrayList<Property> get_properties(){
        ArrayList<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM "+ PROPERTY_TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            properties.add(new Property(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4)
            ));
        }
        return properties;
    }

    public boolean add_room(Property property){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ROOM_NAME_COL, property.getPro_name());
        values.put(ROOM_DESCRIPTION_COL, property.getPro_type());

        long check = db.insert(ROOM_TABLE_NAME, null, values );
        if(check!=-1) return  true;
        else  return false;
    }

    public ArrayList<Room> get_rooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM "+ ROOM_TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            rooms.add(new Room(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            ));
        }
        return rooms;
    }
}


