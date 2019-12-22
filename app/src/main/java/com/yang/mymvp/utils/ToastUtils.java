package com.yang.mymvp.utils;

import android.widget.Toast;

import com.yang.mymvp.base.BaseApp;

public class ToastUtils {
    public static void showToastShrot(String toast){
        Toast.makeText(BaseApp.sContext, ""+toast, Toast.LENGTH_SHORT).show();
    }
    public static void showToastLong(String toast){
        Toast.makeText(BaseApp.sContext, ""+toast, Toast.LENGTH_LONG).show();
    }
}
