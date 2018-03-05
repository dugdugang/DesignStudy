package com.dg.designstudy.Factory;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

public class SimpleFactory extends Factory {

    @Override
    <T extends Product> T createProduct(Class<T> c) {
        Product product=null;
        try {
            product= (Product) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
