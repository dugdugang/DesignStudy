package com.dg.designstudy.Factory;

/**
 * Created by Administrator on 2018/2/27 0027.
 * 静态工厂模 式
 */

public class StaticFactory {
    public static Product createProduct() {
        return new ProductA();
    }
}
