package com.linshao.shopcar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class TwoLevelActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private LinearLayout llCbox;
    private ImageView ivCbox;
    private TextView tvCbox;
    private TextView tvNumber;
    private Level2Adapter adapter;
    private List<Car2ItemBean> list;
    private int totalNum, checkNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        llCbox = (LinearLayout) findViewById(R.id.ll_cbox);
        ivCbox = (ImageView) findViewById(R.id.iv_cbox);
        tvCbox = (TextView) findViewById(R.id.tv_cbox);
        tvNumber = (TextView) findViewById(R.id.tv_number);
        list = new ArrayList<>();
        list.add(new Car2ItemBean(0, "蔬菜瓜果店", 4, 0));
        list.add(new Car2ItemBean(0, "西红柿", "又大又甜真好吃"));
        list.add(new Car2ItemBean(0, "大白菜", "酸辣白菜不要钱"));
        list.add(new Car2ItemBean(0, "红萝卜", "小白兔最爱"));
        list.add(new Car2ItemBean(0, "瘦猪肉", "小炒肉"));
        list.add(new Car2ItemBean(5, "野味餐厅", 2, 0));
        list.add(new Car2ItemBean(5, "红烧-熊-猫", "国-宝才好吃"));
        list.add(new Car2ItemBean(5, "清蒸-娃-娃-鱼", "野生活捉"));
        totalNum = 6;//仅添加商品数量
        adapter = new Level2Adapter(list);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_item_cbox) {//商品选择    核心点   1商品变化  2要去更新店铺中选择的数量   3再修改是否选中  4总选中数量变化
                    Car2ItemBean goodBean = list.get(position);
                    boolean b = goodBean.isChecked();
                    Car2ItemBean shopBean = list.get(goodBean.getpPos());//获取父类数据
                    if (b) {//进行取消操作
                        checkNum--;
                        shopBean.setCheckNum(shopBean.getCheckNum() - 1);//2
                    } else {
                        checkNum++;
                        shopBean.setCheckNum(shopBean.getCheckNum() + 1);//2
                    }
                    shopBean.setChecked(shopBean.getCheckNum() == shopBean.getTotalNum());//3
                    goodBean.setChecked(!b);//此处设置要放在最后一步   1
                } else {//店铺选择
                    Car2ItemBean shopBean = list.get(position);
                    boolean b = shopBean.isChecked();
                    if (b) {//反选
                        checkNum -= shopBean.getTotalNum();
                        shopBean.setCheckNum(0);
                    } else {
                        checkNum += shopBean.getTotalNum();
                        shopBean.setCheckNum(shopBean.getTotalNum());
                    }
                    for (int i = position + 1; i <= position + shopBean.getTotalNum(); i++) {//讲店铺中商品选中状态更改
                        list.get(i).setChecked(!b);
                    }
                    shopBean.setChecked(!b);
                }
                ivCbox.setImageResource(checkNum == totalNum ? R.drawable.ic_radio_button_checked_black_24dp : R.drawable.ic_radio_button_unchecked_black_24dp);
                tvCbox.setText(checkNum == totalNum ? "全不选" : "全选");
                tvNumber.setText("已选" + checkNum + "件商品");
                adapter.notifyDataSetChanged();
            }
        });
        llCbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Car2ItemBean bean : list) {
                    if (bean.getNowItemType() == Car2ItemBean.SHOP) {
                        bean.setCheckNum(checkNum == totalNum ? 0 : bean.getTotalNum());
                    }
                    bean.setChecked(checkNum != totalNum);
                }
                adapter.notifyDataSetChanged();
                ivCbox.setImageResource(checkNum == totalNum ? R.drawable.ic_radio_button_unchecked_black_24dp : R.drawable.ic_radio_button_checked_black_24dp);
                tvCbox.setText(checkNum == totalNum ? "全选" : "全不选");
                checkNum = (checkNum == totalNum) ? 0 : totalNum;
                tvNumber.setText("已选" + checkNum + "件商品");
            }
        });
    }
}

