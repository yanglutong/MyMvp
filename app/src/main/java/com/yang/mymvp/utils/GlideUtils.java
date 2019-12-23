package com.yang.mymvp.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {
    //加载图片
    public static void LoadingImage(Context context, String url, ImageView image){
        Glide.with(context).load(url).into(image);
    }
    //加载占位图片
    public static void loadingImage(Context context,String url,int resId,ImageView image){
        Glide.with(context).load(url).apply(new RequestOptions().placeholder(resId)).into(image);
    }
    //加载圆角占位
    public static void loadingCircleImage(Context context,String url,int resId,ImageView image){
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(context).load(url).apply(requestOptions.placeholder(resId)).apply(requestOptions.circleCrop()).into(image);
    }
}
