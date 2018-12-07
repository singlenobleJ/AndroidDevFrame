package com.llj.basemodule.widget.listview;

import android.content.Context;

import java.util.List;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 14:27
 *     desc  : 通用的单条目Adapter封装
 * </pre>
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {

    public CommonAdapter(Context context, final int layoutId, List<T> dataList) {
        super(context, dataList);

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

    protected abstract void convert(ViewHolder viewHolder, T item, int position);

}
