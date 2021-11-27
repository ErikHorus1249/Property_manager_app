package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.propertymanager.DatabaseHelper.DatabaseHelper;
import com.example.propertymanager.Model.Property;
import com.example.propertymanager.Model.Room;

public class Add_room extends AppCompatActivity {

    ImageButton add_room_back_button, add_room_add_button;
    EditText add_room_name,add_room_description;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        add_room_back_button = findViewById(R.id.add_room_back_button);
        add_room_add_button = findViewById(R.id.add_room_add_button);
        add_room_name = findViewById(R.id.add_room_name);
        add_room_description = findViewById(R.id.add_room_description);

        databaseHelper = new DatabaseHelper(getBaseContext());

        add_room_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        add_room_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = add_room_name.getText().toString().trim();
                String roomDesc = add_room_description.getText().toString().trim();

                boolean status = databaseHelper.add_room(new Room(roomName, roomDesc));
                if(status){
                    Toast.makeText(getBaseContext(), "Added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), List_room.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getBaseContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}