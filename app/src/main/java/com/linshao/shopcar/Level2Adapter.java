package com.linshao.shopcar;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Level2Adapter extends BaseMultiItemQuickAdapter<Car2ItemBean, BaseViewHolder> {
    public Level2Adapter(List<Car2ItemBean> data) {
        super(data);
        addItemType(Car2ItemBean.SHOP, R.layout.item_shop_layout);
        addItemType(Car2ItemBean.GOOD, R.layout.item_single_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, Car2ItemBean item) {
        if (item.getItemType() == Car2ItemBean.SHOP) {
            helper.setImageResource(R.id.iv_item_shop_cbox, item.isChecked() ? R.drawable.ic_radio_button_checked_black_24dp : R.drawable.ic_radio_button_unchecked_black_24dp)
                    .setText(R.id.tv_item_name, item.getShopName())
                    .addOnClickListener(R.id.iv_item_shop_cbox);
        } else {
            helper.setImageResource(R.id.iv_item_cbox, item.isChecked() ? R.drawable.ic_radio_button_checked_black_24dp : R.drawable.ic_radio_button_unchecked_black_24dp)
                    .setText(R.id.tv_item_name, item.getGoodName())
                    .setText(R.id.tv_item_desc, item.getGoodDesc())
                    .addOnClickListener(R.id.iv_item_cbox);
        }
    }
}