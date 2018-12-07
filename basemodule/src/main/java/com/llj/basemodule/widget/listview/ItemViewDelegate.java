package com.llj.basemodule.widget.listview;


/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 14:27
 *     desc  : Item封装
 * </pre>
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);


}
