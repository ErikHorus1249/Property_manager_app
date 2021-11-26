package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

import android.annotation.SuppressLint;
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

import com.example.propertymanager.DatabaseHelper.DatabaseHelper;
import com.example.propertymanager.Model.Property;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class List_property extends AppCompatActivity {

    ListView list_pro;
    ImageButton list_pro_add;
    ArrayList<Property> properties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_property);



        list_pro = findViewById(R.id.list_pro);
//        list_pro_add = findViewById(R.id.list_pro_add);

        DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext());
        properties = databaseHelper.get_properties();

        registerForContextMenu(list_pro);

//        ArrayList<Property> list_property = new ArrayList<>();
//        list_property.add(new Property("San pham 1", "dien tu", "12000", 1));
//        list_property.add(new Property("San pham 2", "da dung", "18000", 2));
//        list_property.add(new Property("San pham 3", "dien lanh", "12000", 4));
//        list_property.add(new Property("San pham 4", "Trang tri", "12000", 7));

        PropertyAdapter propertyAdapter = new PropertyAdapter(getBaseContext(), R.layout.custom_pro_list_item, properties);

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
                return true;
            case R.id.delete_action:
                Toast.makeText(this, "delete  selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

}