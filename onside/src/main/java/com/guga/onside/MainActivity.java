package com.guga.onside;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.guga.lib.utils.DataUtils;
import com.guga.lib.utils.UCUtils;
import com.guga.onside.base.BaseActivity;
import com.guga.onside.base.OsAnnotation;

@OsAnnotation(layoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!UCUtils.getInstance().isValidUser()) {

        }
    }

}
