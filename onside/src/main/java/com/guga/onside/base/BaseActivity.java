package com.guga.onside.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.guga.lib.inject.InjectUtils;
import com.guga.lib.inject.InjectView;

import java.lang.annotation.Annotation;

/**
 * Created by pingfu on 16/1/13.
 */
public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtils.autoInject(this);
    }

    private void getLayoutId() {
        Annotation anno = getClass().getAnnotation(OsBaseAnno.class);
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
