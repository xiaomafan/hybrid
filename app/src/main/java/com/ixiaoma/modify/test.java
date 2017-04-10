package com.ixiaoma.modify;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ixiaoma.modify.testfactory.ConcrateProductA;
import com.ixiaoma.modify.testfactory.ConcreteFactory;
import com.ixiaoma.modify.testfactory.FactoryA;
import com.ixiaoma.modify.testfactory.Product;

/**
 * Created by xiaoma on 2017/2/28.
 */

public class test extends Activity {

    private Button mBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mBtn = (Button) findViewById(R.id.btn_get);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testLibrary();
            }
        });
    }
    
    private void testLibrary(){
//        LogHelper.e("xiaoma","引用library");
    }
    
    private void testFactory(){
        ConcreteFactory factory = new ConcreteFactory();
        Product product = factory.createProduct();
        product.method();

        FactoryA factoryA = new FactoryA();
        ConcrateProductA productA = factoryA.concreteProduct(ConcrateProductA.class);
        productA.method();

    }

}
