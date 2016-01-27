package com.guga.lib.base;

/**
 * Created by pingfu on 16/1/27.
 */
public interface INetworkContext {
    /**
     * 在发送请求之前
     */
    void onNetStart();

    /**
     *
     */
    void onNetCancel();

    /**
     *
     */
    void onNetCompleted();

    /**
     *
     */
    void onNetError();
}
