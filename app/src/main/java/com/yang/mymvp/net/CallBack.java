package com.yang.mymvp.net;

public interface CallBack<T> {
    void onReuccess(T jsonBean);

    void onFail(String msg);
}
