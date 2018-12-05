package com.llj.basemodule.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 11:26
 *     desc  : 基础Activity
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView, View.OnClickListener {

    private static final String TAG = "BaseActivity";
    protected View mContentView;
    protected Activity mActivity;

    private long mLastClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseView(bindLayout());
        initView(savedInstanceState, mContentView);
        mActivity = this;
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
    }

    @SuppressLint("ResourceType")
    protected void setBaseView(@LayoutRes int layoutId) {
        if (layoutId <= 0) return;
        setContentView(mContentView = LayoutInflater.from(this).inflate(layoutId, null));
    }


    /**
     * 判断是否快速点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - mLastClick >= 200) {
            mLastClick = now;
            return false;
        }
        return true;
    }

    @Override
    public void onClick(final View view) {
        if (!isFastClick()) onWidgetClick(view);
    }
}
