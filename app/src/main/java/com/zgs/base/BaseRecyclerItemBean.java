package com.zgs.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by zgsHighwin on 2017/7/19 0019.
 * <p>
 * Email zgshighwin@gmail.com
 * <p>
 * Description:
 */

public class BaseRecyclerItemBean {

    public BaseRecyclerItemBean(Class<? extends AppCompatActivity> aClass, String name) {
        mClass = aClass;
        this.name = name;
    }

    private Class<? extends AppCompatActivity> mClass;

    private String name;

    public Class<? extends AppCompatActivity> getClazz() {
        return mClass;
    }

    public void setClazz(Class<? extends AppCompatActivity> aClass) {
        mClass = aClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
