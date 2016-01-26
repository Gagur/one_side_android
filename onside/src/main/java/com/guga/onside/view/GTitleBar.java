package com.guga.onside.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guga.lib.inject.InjectUtils;
import com.guga.lib.inject.From;
import com.guga.onside.R;

/**
 * Created by pingfu on 16/1/13.
 */
public class GTitleBar extends LinearLayout{
    @From(R.id.ll_back)
    private LinearLayout llLeft;

    @From(R.id.img_back)
    private ImageView imgBack;

    @From(R.id.tv_title)
    private TextView tvTitle;

    public GTitleBar(Activity context) {
        super(context);
        init();
    }

    public GTitleBar(Activity context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        inflate(getContext(), R.layout.lib_title_bar, this);
        InjectUtils.autoInject(this);
    }

    /**
     *
     * @param backPressedListner
     */
    public void setOnBackPressedListner(OnClickListener backPressedListner) {
        llLeft.setOnClickListener(backPressedListner);
    }

    /**
     *
     * @param resId
     */
    public void setBackPressedButtonImage(int resId) {
        try {
            imgBack.setImageResource(resId);
        } catch (Exception e) {

        }
    }
}
