package com.guga.lib.utils;

/**
 * 用户中心的工具类
 * Created by pingfu on 16/1/18.
 */
public class UCUtils {
    private static UCUtils instance;

    /**
     * 用户名，
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;


    private String uid;

    private boolean isValid;

    private UCUtils() {

    }

    public synchronized static UCUtils getInstance() {
        if(instance == null) {
            instance = new UCUtils();
        }

        return instance;
    }

    public boolean isValidUser() {
        return isValid();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
