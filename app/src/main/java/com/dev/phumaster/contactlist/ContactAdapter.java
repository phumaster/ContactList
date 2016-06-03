package com.dev.phumaster.contactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phumaster on 03/06/2016.
 */
public class ContactAdapter extends ArrayAdapter {

    public int activity;
    ArrayList<Contact> contact;
    TextView txtName, txtNumber;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> items) {
        super(context, resource, items);
        this.activity = resource;
        this.contact = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater layout = LayoutInflater.from(getContext());
            convertView = layout.inflate(this.activity, null);
        }
        txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtNumber = (TextView) convertView.findViewById(R.id.txtNumber);

        txtName.setText(this.contact.get(position).getName());
        txtNumber.setText(this.contact.get(position).getNumber()+"");

        return convertView;
    }

}
