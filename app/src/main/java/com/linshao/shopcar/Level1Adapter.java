package com.linshao.shopcar;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Level1Adapter extends BaseQuickAdapter<CarItemBean, BaseViewHolder> {
    public Level1Adapter(@Nullable List<CarItemBean> data) {
        super(R.layout.item_single_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarItemBean item) {
        helper.setImageResource(R.id.iv_item_cbox, item.isChecked() ? R.drawable.ic_radio_button_checked_black_24dp : R.drawable.ic_radio_button_unchecked_black_24dp)
                .setText(R.id.tv_item_name, item.getName())
                .setText(R.id.tv_item_desc, item.getDesc())
                .addOnClickListener(R.id.iv_item_cbox);
    }
}
