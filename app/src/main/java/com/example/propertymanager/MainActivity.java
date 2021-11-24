package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton main_add_property, main_add_room, main_property;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_add_property = findViewById(R.id.main_add_property);
        main_add_room = findViewById(R.id.main_add_room);
        main_property = findViewById(R.id.main_property);

        main_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), List_property.class);
                startActivity(intent);
            }
        });

        main_add_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Add_room.class);
                startActivity(intent);
            }
        });

        main_add_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Add_property.class);
                startActivity(intent);
            }
        });
    }
}