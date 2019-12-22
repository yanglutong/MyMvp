package com.yang.mymvp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class BaseApp extends Application {
    public  static  Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
    }
    public  static  Resources getRes(){
        Resources resources = sContext.getResources();
        return resources;
    }
}
