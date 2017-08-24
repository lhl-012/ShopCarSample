package com.linshao.shopcar;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Car2ItemBean implements MultiItemEntity{
    public static final int SHOP = 1;
    public static final int GOOD = 2;

    private String shopName;//店铺名称
    private String goodName;//商品名称
    private String goodDesc;//商品描述
    private int totalNum;//店铺中商品总量
    private int checkNum;//店铺中商品选中数量
    private int nowItemType;//区分类型
    private boolean checked;//是否选中  店铺  商品item都用
    private int pPos;//数据分组标识

    public Car2ItemBean(int pos,String shopName, int totalNum, int checkNum) {
        this.nowItemType=SHOP;
        this.pPos=pos;
        this.shopName = shopName;
        this.totalNum = totalNum;
        this.checkNum = checkNum;
    }

    public Car2ItemBean(int pos,String goodName, String goodDesc) {
        this.nowItemType=GOOD;
        this.pPos=pos;
        this.goodName = goodName;
        this.goodDesc = goodDesc;
    }

    public int getpPos() {
        return pPos;
    }

    public void setpPos(int pPos) {
        this.pPos = pPos;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getNowItemType() {
        return nowItemType;
    }

    public void setNowItemType(int nowItemType) {
        this.nowItemType = nowItemType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodDesc() {
        return goodDesc;
    }

    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(int checkNum) {
        this.checkNum = checkNum;
    }

    @Override
    public int getItemType() {
        return getNowItemType();
    }
}
