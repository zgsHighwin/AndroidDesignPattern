package com.zgs.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.zgs.R;
import com.zgs.commoninterface.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerActivity extends AppCompatActivity {

    private RecyclerAdapter mRecyclerAdapter;

    protected List<BaseRecyclerItemBean> mClassNameList;

    private RecyclerView mRecyclerView;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycler);

    }

    /**
     * @author zgsHighwin
     * @created at 2017/7/11 0011 下午 3:54
     * @Description: setContentView()或者addContentView()方法执行完毕时就会调用该方法
     */
    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.d("BaseRecyclerActivity", "onContentChanged");
        mClassNameList = new ArrayList<>();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setAdapter();
    }

    /**
     * @author zgsHighwin
     * @created at 2017/7/11 0011 下午 5:15
     * @Description: 设置adapter的适配器
     */
    private void setAdapter() {
        if (mRecyclerAdapter == null) {
            mRecyclerAdapter = new RecyclerAdapter(mClassNameList);
        }
        addClassList();
        mRecyclerAdapter.notifyDataSetChanged();
        mRecyclerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(BaseRecyclerActivity.this, mClassNameList.get(position).getClazz()));
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    protected void OnItemClickListener(View view, int position) {
        startActivity(new Intent(this, mClassNameList.get(position).getClazz()));
    }

    public abstract List<BaseRecyclerItemBean> addClassList();

    public RecyclerAdapter getRecyclerAdapter() {
        return mRecyclerAdapter;
    }
}
