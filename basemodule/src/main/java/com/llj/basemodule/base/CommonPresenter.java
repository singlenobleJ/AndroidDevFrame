package com.llj.basemodule.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 17:43
 *     desc  : 基础Presenter类
 * </pre>
 */
public class CommonPresenter<V extends BaseView> implements BasePresenter<V>, LifecycleObserver {

    private CompositeDisposable mCompositeDisposable;
    private WeakReference<V> mRefView;

    @Override
    public void attachView(V view) {
        mRefView = new WeakReference<>(view);
    }

    protected boolean isViewAttached() {
        return mRefView != null && mRefView.get() != null;
    }

    protected V getView() {
        return mRefView.get();
    }

    /**
     * 增加订阅关系
     *
     * @param disposable
     */
    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    /**
     * 清除订阅关系
     */
    private void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void detachView() {
        if (mRefView != null) {
            mRefView.clear();
            mRefView = null;
        }
        unSubscribe();
    }


}
