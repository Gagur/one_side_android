package com.guga.onside.base;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.guga.lib.inject.InjectUtils;
import com.guga.lib.utils.UCUtils;
import com.guga.onside.model.BaseParam;
import com.guga.onside.view.ConfigDialog;
import com.guga.onside.view.GTitleBar;

/**
 * Created by pingfu on 16/1/13.
 */
public class BaseActivity extends AppCompatActivity {
    private LinearLayout rootView;
    protected GTitleBar mTitleBar;
    private long lastShowConfigDialogTime = System.currentTimeMillis();
    private ConfigDialog mConfigDialog;

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

        if(EnvironmentHandler.isDevEnvironment()) {
            SensorManagerHelper sensorManagerHelper = new SensorManagerHelper(this);
            sensorManagerHelper.setOnShakeListener(new SensorManagerHelper.OnShakeListener() {
                @Override
                public void onShake() {
                    showConfigDialog();
                }
            });
        }
    }

    private void showConfigDialog() {
        if(mConfigDialog == null) {
            mConfigDialog = new ConfigDialog(this);
        }
        if(mConfigDialog.isShowing()) {
            mConfigDialog.dismiss();
        } else {
            mConfigDialog.show();
        }
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

    protected void startRequest(ServiceMap serviceMap, BaseParam param) {

    }

    public static class SensorManagerHelper implements SensorEventListener {
        private static final int SPEED_SHRES_HOLD = 3000;
        private static final int UPDATE_INTERVAL_TIME = 50;
        private SensorManager sensorManager;
        private Sensor sensor;
        private OnShakeListener onShakeListener;
        private Context context;
        private float lastX;
        private float lastY;
        private float lastZ;
        private long lastUpdateTime;

        public SensorManagerHelper(Context context) {
            this.context = context;
            start();
        }

        public void start() {
            sensorManager = (SensorManager) context
                    .getSystemService(Context.SENSOR_SERVICE);
            if (sensorManager != null) {
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            }
            if (sensor != null) {
                sensorManager.registerListener(this, sensor,
                        SensorManager.SENSOR_DELAY_GAME);
            }
        }

        public void stop() {
            sensorManager.unregisterListener(this);
        }

        public interface OnShakeListener {
            void onShake();
        }

        // 设置重力感应监听器
        public void setOnShakeListener(OnShakeListener listener) {
            onShakeListener = listener;
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            long currentUpdateTime = System.currentTimeMillis();
            long timeInterval = currentUpdateTime - lastUpdateTime;
            if (timeInterval < UPDATE_INTERVAL_TIME) return;
            lastUpdateTime = currentUpdateTime;
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            float deltaX = x - lastX;
            float deltaY = y - lastY;
            float deltaZ = z - lastZ;
            lastX = x;
            lastY = y;
            lastZ = z;
            double speed = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ
                    * deltaZ)
                    / timeInterval * 10000;
            if (speed >= SPEED_SHRES_HOLD)
                onShakeListener.onShake();
        }
    }
}
