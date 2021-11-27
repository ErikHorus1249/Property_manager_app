package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.parser.IntegerParser;
import com.example.propertymanager.DatabaseHelper.DatabaseHelper;
import com.example.propertymanager.Model.Property;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class List_property extends AppCompatActivity {

    ListView list_pro;
    LottieAnimationView list_pro_add;
    ArrayList<Property> properties;
    int selected_row;
    DatabaseHelper databaseHelper;
    PropertyAdapter propertyAdapter;
    Property selected_pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_property);



        list_pro = findViewById(R.id.list_pro);
        list_pro_add = findViewById(R.id.list_pro_add);


        databaseHelper = new DatabaseHelper(getBaseContext());
        properties = databaseHelper.get_properties();

        registerForContextMenu(list_pro);

        propertyAdapter = new PropertyAdapter(getBaseContext(), R.layout.custom_pro_list_item, properties);

        list_pro.setAdapter(propertyAdapter);

        list_pro.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selected_pro = (Property)parent.getItemAtPosition(position);
                selected_row = selected_pro.getPro_id();
                return false;
            }
        });

        list_pro_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Add_property.class);
                startActivity(intent);
            }
        });


    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.getItemId() == R.id.edit_action) {
                item.setIcon(getDrawable(R.drawable.edit_actionn));}
            if (item.getItemId() == R.id.delete_action) {
                item.setIcon(getDrawable(R.drawable.delete_action));
            }
        }
        getMenuInflater().inflate(R.menu.custom_property_action_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_action:
                Toast.makeText(this, "edit  selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), Edit_property.class);

                intent.putExtra("pro_id", selected_row);
                intent.putExtra("pro_name", selected_pro.getPro_name());
                intent.putExtra("pro_price", selected_pro.getPro_price());
                intent.putExtra("pro_type", selected_pro.getPro_type());
                intent.putExtra("pro_pos", selected_pro.getPro_pos());

                startActivity(intent);
                return true;
            case R.id.delete_action:
                databaseHelper.delete_property(selected_row);
                properties = databaseHelper.get_properties();
                propertyAdapter = new PropertyAdapter(getBaseContext(), R.layout.custom_pro_list_item, properties);
                list_pro.setAdapter(propertyAdapter);
                Toast.makeText(this, "delete  successfully", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.filter_action:
                ArrayList<Property> filteredProperties = new ArrayList<>();
                for( Property property: properties){
                    if(Integer.parseInt(property.getPro_price()) > 10000000){
                        filteredProperties.add(property);
                    }
                }
                if(!filteredProperties.isEmpty()){
                    propertyAdapter = new PropertyAdapter(getBaseContext(), R.layout.custom_pro_list_item, filteredProperties);
                    list_pro.setAdapter(propertyAdapter);
                }else {
                    Toast.makeText(getBaseContext(), "Empty data", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.refresh_action:
                propertyAdapter = new PropertyAdapter(getBaseContext(), R.layout.custom_pro_list_item, properties);
                list_pro.setAdapter(propertyAdapter);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

}