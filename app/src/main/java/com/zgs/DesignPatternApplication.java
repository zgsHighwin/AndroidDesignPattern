package com.zgs;

import android.app.Application;
import android.content.Context;

/**
 * Created by zgsHighwin on 2017/7/19 0019.
 * <p>
 * Email zgshighwin@gmail.com
 * <p>
 * Description:
 */

public class DesignPatternApplication extends Application {

    private static DesignPatternApplication sDesignPatternApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sDesignPatternApplication = this;
    }

    public DesignPatternApplication getDesignPatternApplication() {
        return sDesignPatternApplication;
    }

    public Context getDesignPatternsApplicationContext() {
        return sDesignPatternApplication.getApplicationContext();
    }
}
