package com.dg.designstudy.SignleInstace;

import java.io.ObjectStreamException;

/**
 * Created by Administrator on 2018/2/23 0023.
 * 静态类部类，最优
 */

public class StaticInnerClass {
    private StaticInnerClass() {
    }

    public static People getPeople() {
        return PeopleHolder.mPeople;
    }

    /**
     * 静态内部类
     */
    public static class PeopleHolder {
        private static final People mPeople = new People();
    }

//    //反序列化时不重新生成对象
//    private Object readResolve() throws ObjectStreamException{
//
//    }
}
