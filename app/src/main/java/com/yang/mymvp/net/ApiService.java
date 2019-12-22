package com.yang.mymvp.net;

import com.yang.mymvp.bean.JsonBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String str="http://test.seetaoism.com/app/v_1_1/article/";
    @GET("recommendlist")
    Observable<JsonBean> observalbe(@Query("from") String android,@Query("lang") String zh);
}
