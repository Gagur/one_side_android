package com.guga.onside.base;

import android.app.Application;
import com.guga.lib.utils.DataUtils;

/**
 * Created by pingfu on 16/2/25.
 */
public class OSApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataUtils.initUserInfo(this);
    }
}
