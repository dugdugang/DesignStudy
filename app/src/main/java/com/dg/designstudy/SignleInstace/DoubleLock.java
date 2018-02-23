package com.dg.designstudy.SignleInstace;

/**
 * Created by Administrator on 2018/2/23 0023.
 * 双重锁定
 */

public class DoubleLock {
    private static People mPeople = null;

    private DoubleLock() {
    }

    public static People getInstacne() {
        if (mPeople == null) {
            synchronized (People.class) {
                if (mPeople == null) {
                    mPeople = new People();
                }
            }
        }
        return mPeople;
    }
}
