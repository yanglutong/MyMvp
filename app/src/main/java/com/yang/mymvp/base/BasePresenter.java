package com.yang.mymvp.base;

import com.yang.mymvp.model.MainModel;

import java.util.ArrayList;

public abstract class BasePresenter<V> {
    protected V mView;
    protected MainModel mainModel;
    private ArrayList<BaseModel> models=new ArrayList<>();
    public BasePresenter (){
        initModel();
    }

    protected abstract void initModel();

    public void attachView(V mView){
        this.mView=mView;
    }

    //当数据不等于时
    public void addView(BaseModel model){
        if(model != null){
            models.add(model);
        }
    }
    public void onDestroy() {
        //打断网络请求
        for (int i = 0; i <models.size() ; i++) {
            BaseModel baseModel = models.get(i);
            baseModel.onDestroy();
        }
        //清空集合
        models.clear();
        //打断p层 和m层的关联
        mView=null;
    }
}
