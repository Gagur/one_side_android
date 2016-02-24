package com.guga.lib.net.utils;

import android.util.Log;

import com.guga.lib.BuildConfig;

/**
 * Created by zhy on 15/11/6.
 */
public class HttpConstants {

    private static boolean debug = false;

    public static void e(String msg) {
        if (debug) {
            Log.e("OkHttp", msg);
        }
    }

}

