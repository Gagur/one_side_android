package com.guga.onside.base;

import android.app.Application;
import com.guga.lib.utils.DataUtils;

/**
 * the application, which used to init the basic info of the app
 *
 * Created by pingfu on 16/2/25.
 */
public class OSApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataUtils.initUserInfo(this);
    }
}
