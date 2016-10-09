package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView img_picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        img_picasso = (ImageView) findViewById(R.id.img_picasso);

        Picasso.with(this).
                load("http://4493bz.1985t.com/uploads/allimg/150126/4-150126153144.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .resize(100,100)
                .centerCrop()
                .into(img_picasso);
    }

    public void toB(View v) {
        startActivityForResult(new Intent(MainActivity.this, BActivity.class), 110);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 110 && resultCode == 222) {
            Toast.makeText(this, "requestCode--" + requestCode + "--resultCode--" + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Picasso.with(this).cancelTag(this);
    }
}
