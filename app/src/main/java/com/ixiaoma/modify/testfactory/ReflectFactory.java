package com.ixiaoma.modify.testfactory;

/**
 * Created by xiaoma on 2017/2/28.
 */

public abstract class ReflectFactory {
    
    public abstract <T extends Product> T concreteProduct(Class<T> clazz);
}
