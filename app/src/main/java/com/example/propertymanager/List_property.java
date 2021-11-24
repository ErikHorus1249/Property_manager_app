package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class List_property extends AppCompatActivity {

    ListView list_pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_property);

        list_pro = findViewById(R.id.list_pro);

        ArrayList<Property> list_property = new ArrayList<>();
        list_property.add(new Property("San pham 1", "dien tu", "12000", "Phong 1"));
        list_property.add(new Property("San pham 2", "da dung", "18000", "Phong 2"));
        list_property.add(new Property("San pham 3", "dien lanh", "12000", "Phong 3"));
        list_property.add(new Property("San pham 4", "Trang tri", "12000", "Phong 4"));

        PropertyAdapter propertyAdapter = new PropertyAdapter(getBaseContext(), R.layout.custom_pro_list_item, list_property);

        list_pro.setAdapter(propertyAdapter);

        list_pro.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Property pro = (Property)parent.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), pro.getPro_name(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}