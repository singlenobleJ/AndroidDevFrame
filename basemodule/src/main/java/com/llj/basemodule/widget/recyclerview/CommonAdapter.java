package com.llj.basemodule.widget.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Created by LLJ on 18/12/07.
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDataList;
    protected LayoutInflater mInflater;

    public CommonAdapter(final Context context, final int layoutId, List<T> dataList) {
        super(context, dataList);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDataList = dataList;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);


}
