package com.example.mike.newtask.services;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.newtask.R;

/**
 * Created by Mike on 11/15/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final ImageView profile_pic;
    public final TextView full_name;
    public final TextView state;
    public final TextView city;
    public final TextView phone_number;



    public ViewHolder(View view) {
        super(view);
        mView = view;
        profile_pic = (ImageView) view.findViewById(R.id.profile_pic);
        full_name = (TextView) view.findViewById(R.id.full_name_txt);
        state = (TextView) view.findViewById(R.id.state_txt);
        city = (TextView) view.findViewById(R.id.city_txt);
        phone_number = (TextView) view.findViewById(R.id.phone_no_txt);

    }

    @Override
    public String toString() {
        return super.toString() + " '" + full_name.getText() + "'";
    }
}