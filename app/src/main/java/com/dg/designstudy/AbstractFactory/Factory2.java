package com.dg.designstudy.AbstractFactory;

/**
 * Created by Administrator on 2018/2/28 0028.
 */

public class Factory2 extends AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}
