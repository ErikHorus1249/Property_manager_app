package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.propertymanager.DatabaseHelper.DatabaseHelper;
import com.example.propertymanager.Model.Room;

import java.util.ArrayList;

public class Edit_property extends AppCompatActivity {

    ImageButton edit_pro_cancel_button, edit_pro_save_button;
    EditText edit_pro_name, edit_pro_price;
    ArrayList<String> type, position;
    ArrayList<Room> rooms;
    Spinner edit_pro_type, edit_pro_position;
    DatabaseHelper databaseHelper;
    String pro_name, pro_price, pro_type;
    int pro_pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_property);

        edit_pro_cancel_button = findViewById(R.id.edit_pro_cancel_button);
        edit_pro_name = findViewById(R.id.edit_pro_name);
        edit_pro_price = findViewById(R.id.edit_pro_price);
        edit_pro_type = findViewById(R.id.edit_pro_type);
        edit_pro_position = findViewById(R.id.edit_pro_position);

        position = new ArrayList<>();
        position.add("phong 1");
        position.add("phong 3");
        position.add("phong 4");

        type = new ArrayList<>();
        type.add("Gia dụng");
        type.add("Điện tử");
        type.add("Nội thất");
        type.add("Đồ trang trí");

        pro_name = getIntent().getStringExtra("pro_name");
        pro_price = getIntent().getStringExtra("pro_price");
        pro_type = getIntent().getStringExtra("pro_type");
//        pro_pos = getIntent().getIntExtra("pro_pos");

        databaseHelper = new DatabaseHelper(getBaseContext());

        ArrayAdapter type_adapter = new ArrayAdapter(getBaseContext(), R.layout.custom_spinner_selected_item, type);
        type_adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        ArrayAdapter position_adapter = new ArrayAdapter(getBaseContext(), R.layout.custom_spinner_selected_item, position);
        position_adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        edit_pro_type.setAdapter(type_adapter);
        edit_pro_position.setAdapter(position_adapter);

        setSpinValue(edit_pro_type, pro_type);

        edit_pro_name.setText(pro_name);
        edit_pro_price.setText(pro_price);

        edit_pro_cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), List_property.class);
                startActivity(intent);
            }
        });

        edit_pro_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setSpinValue(Spinner spin, String text)
    {
        for(int i= 0; i < spin.getAdapter().getCount(); i++)
        {
            if(spin.getAdapter().getItem(i).toString().contains(text))
            {
                spin.setSelection(i);
            }
        }

    }
}