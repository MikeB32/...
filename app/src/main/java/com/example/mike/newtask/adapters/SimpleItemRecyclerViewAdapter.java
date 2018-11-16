package com.example.mike.newtask.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mike.newtask.R;
import com.example.mike.newtask.constants.SharedPrefSingleton;
import com.example.mike.newtask.model.DummyContent;
import com.example.mike.newtask.services.ViewHolder;
import com.example.mike.newtask.fragments.ItemListDetailFragment;

import java.util.List;

/**
 * Created by Mike on 11/15/2018.
 */

public class SimpleItemRecyclerViewAdapter
        extends RecyclerView.Adapter<ViewHolder> {



    private final List<DummyContent.DummyItem> mValues;
    private String profilePicUrl,full_name,state,city,phoneNo;

    Context mContext;
    private Boolean mTwoPane;


    public SimpleItemRecyclerViewAdapter(Context context,List<DummyContent.DummyItem> items) {
        mContext = context;
        mValues = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.example_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final    DummyContent.DummyItem mItem2 = mValues.get(position);            //initialize here, not in ViewHolder class
         profilePicUrl =  mValues.get(position).profile_pic;
          full_name =  mValues.get(position).full_name;
          state =  mValues.get(position).state;
          city =  mValues.get(position).city;
         phoneNo =  mValues.get(position).phone_no;

        holder.full_name.setText("Name : " +full_name);
        holder.state.setText("State : " +state);
        holder.city.setText("City : " +city);
        holder.phone_number.setText("Phone Number : " +phoneNo);
        Glide.with(mContext)
                .load(profilePicUrl)
                .fitCenter()
                .override(500,500)
                .into(holder.profile_pic);

        Boolean color = SharedPrefSingleton.read(SharedPrefSingleton.IS_SELECT+position, true);//read boolean in shared preference.


        if(color==false){
            holder.full_name.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.state.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.city.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.phone_number.setTextColor(mContext.getResources().getColor(R.color.colorAccent));



        }else{
            holder.full_name.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            holder.state.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            holder.city.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            holder.phone_number.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));


        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTwoPane = SharedPrefSingleton.read(SharedPrefSingleton.LAYOUT,false);
                if (mTwoPane) {
                Context context = v.getContext();

                Bundle arguments = new Bundle();
                    arguments.putString(ItemListDetailFragment.ARG_ITEM_ID, mItem2.profile_pic);//use without holder

                    ItemListDetailFragment fragment = new ItemListDetailFragment();
                    fragment.setArguments(arguments);
                ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.itemlist_detail_container, fragment)
                            .commit();

                    holder.full_name.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    holder.state.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    holder.city.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    holder.phone_number.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    SharedPrefSingleton.write(SharedPrefSingleton.IS_SELECT+position, false);



                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, com.example.mike.newtask.activities.ItemListDetailActivity.class);

                    intent.putExtra(ItemListDetailFragment.ARG_ITEM_ID, mItem2.profile_pic);



                    holder.full_name.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    holder.state.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    holder.city.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    holder.phone_number.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    SharedPrefSingleton.write(SharedPrefSingleton.IS_SELECT+position, false);




                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }



}