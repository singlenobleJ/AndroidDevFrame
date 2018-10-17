package com.llj.basemodule.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 11:29
 *     desc  :
 * </pre>
 */
public abstract class BaseFragment extends Fragment {
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(provideLayoutId(), container, false);
        initViews();
        return mRootView;
    }

    protected abstract int provideLayoutId();

    protected abstract void initViews();

    protected final <T extends View> T findViewById(@IdRes int id) {
        return mRootView.findViewById(id);

    }
}
