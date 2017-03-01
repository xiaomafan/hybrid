package com.ixiaoma.modify.testfactory;

/**
 * Created by xiaoma on 2017/2/28.
 */

public class FactoryA extends ReflectFactory {
    @Override
    public <T extends Product> T concreteProduct(Class<T> clazz) {
        Product product=null;
        try {
            product=(Product)Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)product;
    }
}
