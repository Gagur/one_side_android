package com.guga.lib.inject;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by pingfu on 16/1/13.
 */
public class InjectUtils {
    /**
     * 自动注入findViewById()
     * @param activity
     *         当前的activity
     */
    public static void autoInject(Activity activity) {
        if(activity == null) {
            return;
        }
        Class<?> classAct = activity.getClass();
        //获取所有的变量
        Field[] fields = classAct.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(From.class)) {//判断是否为InjectView注解
                From from = field.getAnnotation(From.class);//获取InjectView注解
                int id = from.value();//获取注解的值
                if (id > 0) {
                    field.setAccessible(true);//允许范围私有变量
                    try {
                        field.set(activity, activity.findViewById(id));//给当前的变量赋值
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void autoInject(View view) {
        if(view == null) {
            return;
        }
        Class<?> classAct = view.getClass();
        //获取所有的变量
        Field[] fields = classAct.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(From.class)) {//判断是否为InjectView注解
                From from = field.getAnnotation(From.class);//获取InjectView注解
                int id = from.value();//获取注解的值
                if (id > 0) {
                    field.setAccessible(true);//允许范围私有变量
                    try {
                        field.set(view, view.findViewById(id));//给当前的变量赋值
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
