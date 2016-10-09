package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Will on 16/9/13.
 */
public class CActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }

    public void toB(View v) {
//        startActivity(new Intent(CActivity.this, BActivity.class));
        finish();
    }
}
