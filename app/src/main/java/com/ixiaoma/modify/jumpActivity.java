package com.ixiaoma.modify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ixiaoma.hybrid.LibActivity;

/**
 * Created by xiaoma on 2017/4/11.
 */

public class jumpActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tolib);
        findViewById(R.id.btn_jumplib).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jumpActivity.this, LibActivity.class);
                startActivity(intent);
            }
        });
    }
}
