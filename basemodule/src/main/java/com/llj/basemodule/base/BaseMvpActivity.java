package com.llj.basemodule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.llj.basemodule.util.CreateUtils;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 17:55
 *     desc  :
 * </pre>
 */
public abstract class BaseMvpActivity<P extends CommonPresenter> extends BaseActivity implements BaseView {
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = CreateUtils.getT(this, 0);
        mPresenter.attachView(this);
        getLifecycle().addObserver(mPresenter);
    }

    protected abstract void initData();
}
