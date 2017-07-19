package com.zgs.singleton;

import com.zgs.R;
import com.zgs.base.BaseToolBarActivity;

public class SingletonPatternsActivity extends BaseToolBarActivity {


    @Override
    protected CharSequence toolbarTitle() {
        return "单例设计模式";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_singleton_patterns;
    }
}
