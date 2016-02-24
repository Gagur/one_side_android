package com.guga.lib.data;

import android.content.Context;

import com.guga.lib.BuildConfig;

/**
 * Created by pingfu on 16/2/24.
 */
public class Environments {
    private static final String DEBUG = "debug";
    private static final String BETA = "beta";
    private static final String RELEASE = "release";
    private static final String BUILD_TYPE = BuildConfig.BUILD_TYPE;

    /**
     *
     */
    public static final String DEV_HOST_TAG = "DEV_HOST_TAG";

    /**
     *
     */
    public static final String DEFAULT_DEV_HOST = "http://localhost:8080";

    /**
     * @return
     */
    public static String getServerHost(Context context) {
        String host = null;
        if (isDevEnvironment()) {
            SharedPreferenceHandler preferenceHandler = getSharedPreferenceHandler(context);
            host = preferenceHandler.getSharedPreference(DEV_HOST_TAG, "");
        } else if (isReleaseEnvironment()) {
            host = "";
        }

        return host;
    }

    public static boolean isDevEnvironment() {
        return DEBUG.equals(BUILD_TYPE) || BETA.equals(BUILD_TYPE);
    }

    public static boolean isReleaseEnvironment() {
        return RELEASE.equals(BUILD_TYPE);
    }

    private static SharedPreferenceHandler getSharedPreferenceHandler(Context context) {
        return SharedPreferenceHandler.getInstance(context);
    }
}
