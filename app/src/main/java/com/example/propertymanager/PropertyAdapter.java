package com.example.propertymanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.propertymanager.Property;
import com.example.propertymanager.R;

import java.util.ArrayList;

public class PropertyAdapter extends ArrayAdapter<Property> {

    private Context mContext;
    private int mResource;

    public PropertyAdapter(@NonNull Context context, int resource, ArrayList<Property> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView custom_pro_name = convertView.findViewById(R.id.custom_pro_name);
        TextView custom_pro_type = convertView.findViewById(R.id.custom_pro_type);
        TextView custom_pro_price = convertView.findViewById(R.id.custom_pro_price);
        TextView custom_pro_pos = convertView.findViewById(R.id.custom_pro_position);

        custom_pro_name.setText(getItem(position).getPro_name());
        custom_pro_type.setText(getItem(position).getPro_type());
        custom_pro_price.setText(getItem(position).getPro_price());
        custom_pro_pos.setText(getItem(position).getPro_pos());

        return convertView;
    }
}
