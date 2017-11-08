package com.edan.www.baserecyclerviewadapterhelper;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 创建者     Zhangyu
 * 创建时间   2017/11/8 15:56
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author
 * 更新时间   $Date
 * 更新描述   ${TODO}
 */

public class HomeAdapter extends BaseItemDraggableAdapter<String,BaseViewHolder > {

    public HomeAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text, item)
        // 加载网络图片
                .addOnClickListener(R.id.text)
        .addOnClickListener(R.id.button);
    }
}
