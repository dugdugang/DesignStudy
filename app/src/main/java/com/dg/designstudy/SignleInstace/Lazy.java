package com.dg.designstudy.SignleInstace;

/**
 * Created by Administrator on 2018/2/23 0023.
 * 懒汉
 */

public class Lazy {
    private static People mPeople;

    public static synchronized People getPeople() {
        if (mPeople == null) {
            mPeople = new People();
        }
        return mPeople;
    }
}
