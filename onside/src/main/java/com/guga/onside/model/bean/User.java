package com.guga.onside.model.bean;

import com.guga.onside.model.BaseModel;

/**
 * the User model, which is used to save the basic info of the user
 *
 * Created by pingfu on 16/1/18.
 */
public class User extends BaseModel {
    /**
     * the username
     */
    public String username;

    /**
     * the password
     */
    public String password;

    /**
     * the token of the user, which is the unique tag of the user
     */
    public String token;

    /**
     * the id of the user
     */
    public String uid;
}
