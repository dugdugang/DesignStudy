package com.dg.designstudy.SignleInstace;

/**
 * Created by Administrator on 2018/2/23 0023.
 * 饿汉
 */

public class Hungry {
    public static final People mPeople = new People();

    private Hungry() {

    }

    public static People getPeople() {
        return mPeople;
    }


}


