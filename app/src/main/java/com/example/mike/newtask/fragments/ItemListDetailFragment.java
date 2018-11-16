package com.example.mike.newtask.fragments;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mike.newtask.R;
import com.example.mike.newtask.adapters.SimpleItemRecyclerViewAdapter;
import com.example.mike.newtask.model.DummyContent;

import java.util.List;

/**
 * A fragment representing a single ItemList detail screen.
 * This fragment is either contained in a {@link com.example.mike.newtask.activities.ItemListListActivity}
 * in two-pane mode (on tablets) or a {@link com.example.mike.newtask.activities.ItemListListActivity}
 * on handsets.
 */
public class ItemListDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemListDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.itemlist_detail, container, false);
        String aaa= getArguments().getString(ARG_ITEM_ID);


        mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));


        // Show the dummy content as text in a TextView.
        if (mItem != null) {

            ImageView detailed_profile_pic = (ImageView)rootView.findViewById(R.id.detail_profile_pic);
//
            Glide.with(getContext())
                    .load(mItem.profile_pic)
                    .fitCenter()
                    .override(500,500)
                    .into(detailed_profile_pic);

            ((TextView) rootView.findViewById(R.id.detail_full_name_txt)).setText(mItem.full_name);
            ((TextView) rootView.findViewById(R.id.detail_gender_txt)).setText(mItem.gender);
            ((TextView) rootView.findViewById(R.id.detail_email_txt)).setText(mItem.email);
            ((TextView) rootView.findViewById(R.id.detail_phone_no_txt)).setText(mItem.phone_no);
            ((TextView) rootView.findViewById(R.id.detail_cell_no)).setText(mItem.cell);

            ((TextView) rootView.findViewById(R.id.detailed_location)).setText("Street : "+mItem.street +"\nCity : "+mItem.city+
            "\nState : "+mItem.state+"\nPostcode : "+mItem.postcode+"\nCoordinates :\n"+getString(R.string.tab)+"Latitude : "+mItem.latitude+
            "\n"+getString(R.string.tab)+"Longitude : "+mItem.longitude +"\nTimezone :\n"+getString(R.string.tab)+"Offset : "+mItem.offset+
                    "\n"+getString(R.string.tab)+"Description : "+mItem.description+
                            "\nLogin : "+"\n"+getString(R.string.tab)+"Uuid : "+mItem.uuid+"\n"+getString(R.string.tab)+"Username : "+mItem.username+"\n"+getString(R.string.tab)+"Password : "+mItem.password+"\n"+getString(R.string.tab)+"Salt : "+mItem.salt+"\n"+getString(R.string.tab)+"Md5 : "+mItem.md5+"\n"+getString(R.string.tab)+"sha1 : "+mItem.sha1+"\n"+getString(R.string.tab)+"Sha256 : "+mItem.sha256+
                            "\nDob :\n"+getString(R.string.tab)+"date : "+mItem.dobDate+ "\n"+getString(R.string.tab)+"age : "+mItem.dobAge+
                            "\nRegister :\n"+getString(R.string.tab)+"date : "+mItem.registerDate+ "\n"+getString(R.string.tab)+"age : "+mItem.registerAge+
                            "\nId :\n"+getString(R.string.tab)+"name : "+mItem.idName+ "\n"+getString(R.string.tab)+"value : "+mItem.idValue+
                            "\nNationality : "+mItem.nat);


        }

        return rootView;
    }
}
