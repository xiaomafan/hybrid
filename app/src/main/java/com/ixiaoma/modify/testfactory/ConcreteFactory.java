package com.ixiaoma.modify.testfactory;

/**
 * Created by xiaoma on 2017/2/28.
 */

public class ConcreteFactory extends Factory {
    
    
    @Override
    public Product createProduct() {
        return new ConcrateProductA();
    }
}
