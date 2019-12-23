package com.yang.mymvp.base;

import android.os.Bundle;

import com.yang.mymvp.utils.ToastUtils;
import com.yang.mymvp.weight.LoadingDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P presenter = null;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取布局id
        setContentView(getLayoutId());
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        //找到控件方法
        initView();
        //处理逻辑代码
        initData();
    }

    public void showToast(String msg) {
        ToastUtils.showToastShrot(msg);
    }

    @Override
    public void showLoading() {
        if(loadingDialog == null){
            loadingDialog = new LoadingDialog(this);
        }
        if(!loadingDialog.isShowing()){
            loadingDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if(loadingDialog!=null){
            loadingDialog.hide();
        }
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
        presenter = null;
    }
}
