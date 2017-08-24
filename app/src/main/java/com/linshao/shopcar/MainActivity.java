package com.linshao.shopcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private LinearLayout llCbox;
    private ImageView ivCbox;
    private TextView tvCbox;
    private TextView tvNumber;
    private Level1Adapter adapter;
    private List<CarItemBean> list;
    private int totalNum, checkNum = 0;


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
        list.add(new CarItemBean("西红柿", "又大又甜真好吃"));
        list.add(new CarItemBean("大白菜", "酸辣白菜不要钱"));
        list.add(new CarItemBean("红萝卜", "小白兔最爱"));
        list.add(new CarItemBean("瘦猪肉", "小炒肉"));
        adapter = new Level1Adapter(list);
        totalNum = list.size();
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_item_cbox) {
                    boolean b = list.get(position).isChecked();
                    if (b) {
                        checkNum--;
                    } else {
                        checkNum++;
                    }
                    list.get(position).setChecked(!b);
                    adapter.notifyDataSetChanged();
                    ivCbox.setImageResource(checkNum == totalNum ? R.drawable.ic_radio_button_checked_black_24dp : R.drawable.ic_radio_button_unchecked_black_24dp);
                    tvCbox.setText(checkNum == totalNum ? "全不选" : "全选");
                    tvNumber.setText("已选" + checkNum + "件商品");
                }
            }
        });
        llCbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (CarItemBean bean : list) {
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
