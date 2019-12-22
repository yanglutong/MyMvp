package com.yang.mymvp.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseModel {
    //Rxjava自带容器
    CompositeDisposable mCompositeDisposable = null;

    public void onDestroy() {
        if (mCompositeDisposable != null) {
            //将容器中所有对象打断
            mCompositeDisposable.dispose();
        }
    }

    public void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    public void removeDisposable(Disposable disposable) {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.remove(disposable);
        }
    }
}
