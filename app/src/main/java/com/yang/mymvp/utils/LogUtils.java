package com.yang.mymvp.utils;

import android.util.Log;

import com.yang.mymvp.base.Constants;

public class LogUtils {
    public static void log(String msg){
        if(Constants.isDebug){
            Log.i("杨路通", msg);
        }
    }
    public static void print(String msg){
        if(Constants.isDebug){
            System.out.println(msg);
        }
    }
}
