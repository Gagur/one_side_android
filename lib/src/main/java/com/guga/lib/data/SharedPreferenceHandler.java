package com.guga.lib.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by pingfu on 16/1/18.
 */
public class SharedPreferenceHandler {
    private static final String SHARED_PREFERENCE = "SHARED_PREFERENCE";
    private static SharedPreferenceHandler instance = null;

    private SharedPreferences sp;

    private SharedPreferenceHandler(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCE, 0);
        if(sp != null) {
        }
    }

    public synchronized static SharedPreferenceHandler getInstance(Context context) {
        if(instance == null) {
            instance = new SharedPreferenceHandler(context);
        }

        return instance;
    }

    public void saveSharedPreference(String key, String value) {
        if(sp != null) {
            sp.edit().putString(key, value);
            sp.edit().commit();
        }
    }

    public void saveSharedPreference(String key, int value) {
        if(sp != null) {
            sp.edit().putInt(key, value);
            sp.edit().commit();
        }
    }

    public void saveSharedPreference(String savedData, boolean value) {
        if(sp != null) {
            sp.edit().putBoolean(savedData, value);
            sp.edit().commit();
        }
    }

    public void saveSharedPreference(String savedData, Float value) {
        if(sp != null) {
            sp.edit().putFloat(savedData, value);
            sp.edit().commit();
        }
    }

    public String getSharedPreference(String key, String defaultValue) {
        if(sp != null) {
            return sp.getString(key, defaultValue);
        }

        return null;
    }

    public int getSharedPreference(String key, int defaultValue) {
        if(sp != null) {
            return sp.getInt(key, defaultValue);
        }

        return 0;
    }

    public boolean getSharedPreference(String key, boolean defaultValue) {
        if(sp != null) {
            return sp.getBoolean(key, defaultValue);
        }

        return false;
    }

    public float getSharedPreference(String key, float defaultValue) {
        if(sp != null) {
            return sp.getFloat(key, defaultValue);
        }

        return 0;
    }
}
