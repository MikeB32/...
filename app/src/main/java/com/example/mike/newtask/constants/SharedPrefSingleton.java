package com.example.mike.newtask.constants;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mike on 11/15/2018.
 */

public class SharedPrefSingleton {
    private static SharedPreferences mSharedPref;

    public static final String IS_SELECT = "IS_SELECT";
    public static final String LAYOUT = "LAYOUT";



    private SharedPrefSingleton() {

    }

    public static void init(Context context) {
        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }



    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.commit();
    }




}
