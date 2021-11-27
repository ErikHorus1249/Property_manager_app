package com.example.propertymanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.propertymanager.Model.Property;
import com.example.propertymanager.Model.Room;

import java.util.ArrayList;

public class RoomAdapter extends ArrayAdapter<Room> {

    private Context mContext;
    private int mResource;

    public RoomAdapter(@NonNull Context context, int resource, ArrayList<Room> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView custom_room_name = convertView.findViewById(R.id.custom_room_name);
        TextView custom_room_desc = convertView.findViewById(R.id.custom_room_desc);


        custom_room_name.setText(getItem(position).getRoom_name());
        custom_room_desc.setText(getItem(position).getRoom_desc());

        return convertView;
    }

}