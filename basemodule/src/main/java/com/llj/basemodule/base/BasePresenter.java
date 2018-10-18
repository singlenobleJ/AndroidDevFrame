package com.llj.basemodule.base;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 11:38
 *     desc  :
 * </pre>
 */
public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
