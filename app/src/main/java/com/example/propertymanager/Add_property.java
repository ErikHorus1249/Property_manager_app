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

public class Add_property extends AppCompatActivity {

    ImageButton add_pro_back_button, add_pro_add_button;
    EditText add_pro_name, add_pro_price;
    ArrayList<String> type, positions;
    ArrayList<Room> rooms;
    Spinner add_pro_type, add_pro_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);

//        DATABASE HELPER
        DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext());

        rooms = databaseHelper.get_rooms();
        //        get all room for spiner's display
        create_position_example();

        add_pro_back_button = findViewById(R.id.add_pro_back_button);
        add_pro_add_button = findViewById(R.id.add_pro_add_button);
        add_pro_position = findViewById(R.id.add_pro_position);
        add_pro_type = findViewById(R.id.add_pro_type);
        add_pro_name = findViewById(R.id.add_pro_name);
        add_pro_price = findViewById(R.id.add_pro_price);

        create_type_example();
//        create_position_example();

        ArrayAdapter type_adapter = new ArrayAdapter(getBaseContext(), R.layout.custom_spinner_selected_item, type);
        type_adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        ArrayAdapter position_adapter = new ArrayAdapter(getBaseContext(), R.layout.custom_spinner_selected_item, positions);
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

        add_pro_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                handle room's data
                String propertyName = add_pro_name.getText().toString().trim();
                String propertyPrice = add_pro_price.getText().toString().trim();
                String propertyType = add_pro_type.getSelectedItem().toString().trim();
                String propertyRoom = add_pro_position.getSelectedItem().toString().trim();
                int propertyPos = get_room_id_by_name("propertyRoom");
//                int propertyPos = get_room_id_by_name(add_pro_position.getSelectedItem().toString().trim());

                boolean status = databaseHelper.add_property(new Property(propertyName, propertyType, propertyPrice, propertyPos, propertyRoom));
                if(status){
                    Toast.makeText(getBaseContext(), "Thêm thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), List_property.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getBaseContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
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
        positions = new ArrayList<>();
        for( Room room: rooms){
            positions.add(room.getRoom_name());
        }
    }

    public  int get_room_id_by_name(String roomName){
        for (Room room : rooms){
            if(roomName.equals(room.getRoom_name())) return  room.getRooom_id();
        }
        return 0;
    }

}