package com.yang.mymvp.model;

import android.util.Log;

import com.yang.mymvp.base.BaseModel;
import com.yang.mymvp.bean.JsonBean;
import com.yang.mymvp.net.ApiService;
import com.yang.mymvp.net.CallBack;



import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void getData(final CallBack<JsonBean> callBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.str)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<JsonBean> observalbe = apiService.observalbe("android", "zh");
        observalbe.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonBean jsonBean) {
                        Log.i("杨路通", "onNext: " + jsonBean.toString());
                        callBack.onReuccess(jsonBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
