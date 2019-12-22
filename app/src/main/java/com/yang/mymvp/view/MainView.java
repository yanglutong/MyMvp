package com.yang.mymvp.view;

import com.yang.mymvp.base.BaseView;
import com.yang.mymvp.bean.JsonBean;

public interface MainView extends BaseView {
    void setBean(JsonBean jsonBean);

    void setToast(String msg);
}
