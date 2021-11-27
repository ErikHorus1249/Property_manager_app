package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.propertymanager.DatabaseHelper.DatabaseHelper;
import com.example.propertymanager.Model.Property;
import com.example.propertymanager.Model.Room;

import java.util.ArrayList;

public class List_room extends AppCompatActivity {

    ListView list_room;
    LottieAnimationView list_room_add;
    ArrayList<Room>  rooms;
    int selected_row;
    DatabaseHelper databaseHelper;
    RoomAdapter roomAdapter;
    Room selected_room;
    ImageView list_room_heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_room);

        list_room = findViewById(R.id.list_room);
        list_room_add = findViewById(R.id.list_room_add);

        databaseHelper = new DatabaseHelper(getBaseContext());
        rooms = databaseHelper.get_rooms();

        registerForContextMenu(list_room);

        roomAdapter = new RoomAdapter(getBaseContext(), R.layout.custom_room_list_layout, rooms);

        list_room.setAdapter(roomAdapter);



        list_room.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selected_room = (Room) parent.getItemAtPosition(position);
                selected_row = selected_room.getRooom_id();
                return false;
            }
        });

        list_room_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Add_room.class);
                startActivity(intent);
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.getItemId() == R.id.edit_room_action) {
                item.setIcon(getDrawable(R.drawable.edit_actionn));}
            if (item.getItemId() == R.id.delete_room_action) {
                item.setIcon(getDrawable(R.drawable.delete_action));
            }
        }
        getMenuInflater().inflate(R.menu.custom_room_action_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_room_action:
                Intent intent = new Intent(getBaseContext(), Edit_room.class);

                intent.putExtra("room_id", selected_row);
                intent.putExtra("room_name", selected_room.getRoom_name());
                intent.putExtra("room_desc", selected_room.getRoom_desc());

                startActivity(intent);
                return true;
            case R.id.delete_room_action:
                databaseHelper.delete_room(selected_row);
                rooms = databaseHelper.get_rooms();
                roomAdapter = new RoomAdapter(getBaseContext(), R.layout.custom_room_list_layout, rooms);
                list_room.setAdapter(roomAdapter);
                Toast.makeText(this, "delete  successfully", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}