package com.yang.mymvp.base;

import android.os.Bundle;

import com.yang.mymvp.utils.ToastUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public  abstract  class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P presenter=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取布局id
        setContentView(getLayoutId());
        presenter = initPresenter();
        if(presenter != null){
            presenter.attachView(this);
        }
        //找到控件方法
        initView();
        //处理逻辑代码
        initData();
    }

    protected void showToast(String msg) {
        ToastUtils.showToastShrot(msg);
    }

    protected abstract P initPresenter();

    protected void initData() {

    }

    protected abstract void initView();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //当视图界面销毁打断网络请求断开连接

            presenter.onDestroy();
            presenter=null;

    }
}
