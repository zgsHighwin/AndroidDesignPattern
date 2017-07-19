package com.zgs.base;

import java.util.List;

public class MainActivity extends BaseRecyclerActivity {

    @Override
    public List<BaseRecyclerItemBean> addClassList() {
        mClassNameList.add(new BaseRecyclerItemBean(MainActivity.class, "哈哈哈"));
        mClassNameList.add(new BaseRecyclerItemBean(MainActivity.class, "哈哈哈"));
        mClassNameList.add(new BaseRecyclerItemBean(MainActivity.class, "哈哈哈"));
        mClassNameList.add(new BaseRecyclerItemBean(MainActivity.class, "哈哈哈"));
        return mClassNameList;
    }
}
