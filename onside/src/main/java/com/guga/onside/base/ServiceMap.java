package com.guga.onside.base;

import com.guga.onside.model.BaseResult;

/**
 * Created by pingfu on 16/1/26.
 */
public enum ServiceMap {
    OS_CHECK_USER("", BaseResult.class);

    private final String uri;
    private final Class<? extends BaseResult> baseResult;

    ServiceMap(String s, Class<? extends BaseResult> mClass) {
         uri = s;
        baseResult = mClass;
    }

    public String getUri() {
        return uri;
    }

    public Class<? extends BaseResult> getBaseClass() {
        return baseResult;
    }
}
