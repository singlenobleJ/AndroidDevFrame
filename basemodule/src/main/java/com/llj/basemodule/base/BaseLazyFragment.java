package com.llj.basemodule.base;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/18 16:00
 *     desc  :
 * </pre>
 */
public abstract class BaseLazyFragment extends BaseFragment {

    private static final String TAG = "BaseLazyFragment";

    private boolean isDataLoaded;

    public abstract void doLazyBusiness();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && mContentView != null && !isDataLoaded) {
            doLazyBusiness();
            isDataLoaded = true;
        }
    }

    @Override
    public void doBusiness() {
        if (getUserVisibleHint()) {
            doLazyBusiness();
            isDataLoaded = true;
        }
    }
}
