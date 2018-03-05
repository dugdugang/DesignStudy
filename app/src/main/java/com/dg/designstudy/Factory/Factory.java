package com.dg.designstudy.Factory;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

public abstract class Factory {

    abstract <T extends Product> T createProduct(Class<T> c);
}
