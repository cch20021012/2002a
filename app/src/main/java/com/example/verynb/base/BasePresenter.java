package com.example.verynb.base;



import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    WeakReference<V> weakReference;
    protected V mView;
    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<V>(view);
        mView = weakReference.get();
    }

    @Override
    public void unAttachView() {
        weakReference.clear();
        mView = null;
    }
}
