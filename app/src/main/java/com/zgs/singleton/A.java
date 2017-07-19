package com.zgs.singleton;

/**
 * Created by zgsHighwin on 2017/7/19 0019.
 * <p>
 * Email zgshighwin@gmail.com
 * <p>
 * Description:
 */

public class A {

    private volatile static A sAa;

    private A() {

    }

    public static A getInstance() {
        if (sAa == null) {
            synchronized (A.class) {
                if (sAa == null) {
                    sAa = new A();
                }
            }
        }
        return sAa;

    }
}
