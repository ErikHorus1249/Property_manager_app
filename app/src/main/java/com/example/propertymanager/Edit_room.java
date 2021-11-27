package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.propertymanager.DatabaseHelper.DatabaseHelper;
import com.example.propertymanager.Model.Property;
import com.example.propertymanager.Model.Room;

import java.util.ArrayList;

public class Edit_room extends AppCompatActivity {

    ImageButton edit_room_cancel_button, edit_room_save_button;
    EditText edit_room_name, edit_room_desc;
    DatabaseHelper databaseHelper;
    String room_name, room_desc;
    int room_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);

        edit_room_name = findViewById(R.id.edit_room_name);
        edit_room_desc = findViewById(R.id.edit_room_description);
        edit_room_cancel_button = findViewById(R.id.edit_room_cancel_button);
        edit_room_save_button = findViewById(R.id.edit_room_save_button);

        room_id = getIntent().getIntExtra("room_id",0);
        room_name = getIntent().getStringExtra("room_name");
        room_desc = getIntent().getStringExtra("room_desc");

        databaseHelper = new DatabaseHelper(getBaseContext());


        edit_room_name.setText(room_name);
        edit_room_desc.setText(room_desc);

        edit_room_cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), List_room.class);
                startActivity(intent);
            }
        });

        edit_room_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = edit_room_name.getText().toString().trim();
                String roomDesc = edit_room_desc.getText().toString().trim();
//                Toast.makeText(getBaseContext(), roomName + " " + roomDesc + room_id, Toast.LENGTH_SHORT).show();
                if(databaseHelper.update_room(new Room(roomName, roomDesc), room_id)){
                    Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), List_room.class);
                    startActivity(intent);
                }else
                    Toast.makeText(getBaseContext(), "Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}