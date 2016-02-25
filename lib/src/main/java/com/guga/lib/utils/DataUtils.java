package com.guga.lib.utils;

import android.content.Context;

import com.guga.lib.data.SharedPreferenceHandler;

/**
 * Created by pingfu on 16/1/13.
 */
public class DataUtils {
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String IS_VALID = "IS_VALID";


    private DataUtils(Context mContext) {

    }


    /**
     *
     *
     * @return
     */
    public static void initUserInfo(Context context) {
        SharedPreferenceHandler handler = SharedPreferenceHandler.getInstance(context);
        if(handler == null) {
            return;
        }

        UCUtils.getInstance().setUsername(handler.getData(USERNAME, ""));
        UCUtils.getInstance().setPassword(handler.getData(PASSWORD, ""));
        UCUtils.getInstance().setIsValid(handler.getData(IS_VALID, false));
    }
}
