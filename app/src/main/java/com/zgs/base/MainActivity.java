package com.zgs.base;

import com.zgs.singleton.SingletonPatternsActivity;

import java.util.List;

public class MainActivity extends BaseRecyclerActivity {

    @Override
    public List<BaseRecyclerItemBean> addClassList() {
        mClassNameList.add(new BaseRecyclerItemBean(SingletonPatternsActivity.class, "单例设计模式"));
        return mClassNameList;
    }
}
