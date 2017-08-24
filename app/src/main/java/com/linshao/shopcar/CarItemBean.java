package com.linshao.shopcar;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017/8/24.
 */

public class CarItemBean{
    private boolean checked;
    private String name;
    private String desc;

    public CarItemBean(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
