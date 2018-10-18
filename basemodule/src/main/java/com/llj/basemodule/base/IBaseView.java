package com.llj.basemodule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/18 16:01
 *     desc  :
 * </pre>
 */
public interface IBaseView {
    /**
     * 初始化数据
     *
     * @param bundle 传递过来的 bundle
     */
    void initData(@Nullable final Bundle bundle);

    /**
     * 绑定布局
     *
     * @return 布局 Id
     */
    int bindLayout();

    /**
     * 初始化 view
     */
    void initView(final Bundle savedInstanceState, final View contentView);

    /**
     * 业务操作
     */
    void doBusiness();

    /**
     * 视图点击事件
     *
     * @param view 视图
     */
    void onWidgetClick(final View view);
}
