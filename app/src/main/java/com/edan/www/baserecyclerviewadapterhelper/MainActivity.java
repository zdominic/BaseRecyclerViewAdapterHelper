package com.edan.www.baserecyclerviewadapterhelper;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        for (int i = 0; i < 1000; i++) {
            mList.add(String.valueOf(i));
        }
        HomeAdapter adapter = new HomeAdapter(R.layout.item, mList);
        mRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        mRecyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(this);       //点击事件
        adapter.setOnItemChildClickListener(this);      //子控件的点击事件
        adapter.openLoadAnimation();
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN );        //动画效果
        adapter.addHeaderView(View.inflate(this,R.layout.headview,null));

        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerview);

        // 开启拖拽
        adapter.enableDragItem(itemTouchHelper, R.id.button, true);
        adapter.setOnItemDragListener(new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {

            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {

            }
        });

        // 开启滑动删除
        adapter.enableSwipeItem();
        adapter.setOnItemSwipeListener(new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

            }
        });


    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(getApplicationContext(), "第" + position + "被点击了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.text) {
            Toast.makeText(getApplicationContext(), position+"文字被点击了", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), position+"button被点击了", Toast.LENGTH_SHORT).show();
        }
    }
}
