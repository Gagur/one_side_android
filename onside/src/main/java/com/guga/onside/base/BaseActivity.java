package com.guga.onside.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.guga.lib.inject.InjectUtils;
import com.guga.lib.utils.UCUtils;
import com.guga.onside.view.GTitleBar;

/**
 * Created by pingfu on 16/1/13.
 */
public class BaseActivity extends AppCompatActivity {
    private LinearLayout rootView;
    protected GTitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtils.autoInject(this);
        rootView = new LinearLayout(this);
        rootView.setOrientation(LinearLayout.VERTICAL);

        //addTitleBar
        mTitleBar = new GTitleBar(this);
        rootView.addView(mTitleBar);
        mTitleBar.setVisibility(View.GONE);

        try {
            View view = View.inflate(this, getLayoutId(), null);
            rootView.addView(view);
        } catch (Exception e) {

        }
        setContentView(rootView);
    }

    private int getLayoutId() {
        OsAnnotation anno = getClass().getAnnotation(OsAnnotation.class);
        int layoutId = 0;
        if(anno != null) {
            layoutId = anno.layoutId();
        }

        return layoutId;
    }

    protected boolean isValidUser() {
        if(UCUtils.getInstance().isValidUser()) {

        }

        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }


    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
    }
}
