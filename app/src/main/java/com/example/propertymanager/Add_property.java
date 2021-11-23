package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class Add_property extends AppCompatActivity {

    ImageButton add_pro_back_button;
    ArrayList<String> type, position;
    Spinner add_pro_type, add_pro_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);

        add_pro_back_button = findViewById(R.id.add_pro_back_button);
        add_pro_position = findViewById(R.id.add_pro_position);
        add_pro_type = findViewById(R.id.add_pro_type);

        create_type_example();
        create_position_example();

        ArrayAdapter type_adapter = new ArrayAdapter(getBaseContext(), R.layout.custom_spinner_selected_item, type);
        type_adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        ArrayAdapter position_adapter = new ArrayAdapter(getBaseContext(), R.layout.custom_spinner_selected_item, position);
        position_adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        add_pro_type.setAdapter(type_adapter);
        add_pro_position.setAdapter(position_adapter);

        add_pro_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void create_type_example(){
        type = new ArrayList<>();
        type.add("Gia dụng");
        type.add("Điện tử");
        type.add("Nội thất");
        type.add("Đồ trang trí");
    }

    public void create_position_example(){
        position = new ArrayList<>();
        position.add("Phòng số 1");
        position.add("Phòng số 2");
        position.add("Phòng họp số 3");
        position.add("Phòng họp số 4");
    }
}