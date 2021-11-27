package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.propertymanager.DatabaseHelper.DatabaseHelper;
import com.example.propertymanager.Model.Property;

import java.util.ArrayList;
import java.util.Properties;

public class Properties_in_room extends AppCompatActivity {

    ImageButton review_done;
    ListView list_pro_in_room;
    PropertyAdapter propertyAdapter;
    DatabaseHelper databaseHelper;
    ArrayList<Property> properties;

//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties_in_room);

        review_done = findViewById(R.id.review_done);
        list_pro_in_room = findViewById(R.id.list_pro_in_room);

        int roomId = getIntent().getIntExtra("room_id", 0);

        databaseHelper = new DatabaseHelper(getBaseContext());

        properties = databaseHelper.get_properties_by_room(roomId);

//        ArrayList<Property> filted_pro = new ArrayList<>();
//        for(Property property : properties){
//
////            if(property.getPro_pos() == roomId) filted_pro.add(property);
//        }

        registerForContextMenu(list_pro_in_room);

        propertyAdapter = new PropertyAdapter(getBaseContext(), R.layout.custom_pro_list_item, properties);

        list_pro_in_room.setAdapter(propertyAdapter);

        review_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), List_room.class);
                startActivity(intent);
            }
        });
    }
}