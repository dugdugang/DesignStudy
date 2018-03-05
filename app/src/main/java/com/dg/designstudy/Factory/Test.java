package com.dg.designstudy.Factory;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

public class Test {

    public void test() {
        SimpleFactory factory = new SimpleFactory();
        factory.createProduct(ProductA.class).method();
    }
}
