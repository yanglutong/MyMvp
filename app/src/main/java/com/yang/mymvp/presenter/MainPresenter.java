package com.yang.mymvp.presenter;


import com.yang.mymvp.base.BasePresenter;
import com.yang.mymvp.bean.JsonBean;
import com.yang.mymvp.model.MainModel;
import com.yang.mymvp.net.CallBack;
import com.yang.mymvp.view.MainView;


public class MainPresenter extends BasePresenter<MainView> {
    public void getData() {
        mainModel.getData(new CallBack<JsonBean>() {
            @Override
            public void onReuccess(JsonBean jsonBean) {
                if(jsonBean.getCode()==1&&jsonBean.getData() != null){
                    mView.setBean(jsonBean);
                }
            }

            @Override
            public void onFail(String msg) {
                    mView.setToast(msg);
            }
        });
    }

    @Override
    protected void initModel() {
        mainModel=new MainModel();
        addView(mainModel);
    }
}
