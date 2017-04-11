package com.ixiaoma.hybrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by xiaoma on 2017/4/11.
 */

public class LibActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);
        findViewById(R.id.btn_jumpapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.app.test");
                intent.addCategory("com.app.apppage");
                startActivity(intent);
            }
        });
    }
}
