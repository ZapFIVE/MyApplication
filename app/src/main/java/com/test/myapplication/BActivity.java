package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.myapplication.view.IndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Will on 16/9/13.
 */
public class BActivity extends AppCompatActivity {

    private ViewPager id_viewpager;
    private IndicatorView id_indicator;
    private List<View> viewList;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        id_viewpager = (ViewPager) findViewById(R.id.id_viewpager);
        id_indicator = (IndicatorView) findViewById(R.id.id_indicator);

        viewList = new ArrayList<>();
        titleList = new ArrayList<>();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < 4; i++) {
            TextView tv = new TextView(this);
            tv.setText("Hello World ------ " + i);
            tv.setLayoutParams(params);
            tv.setGravity(Gravity.CENTER);
            viewList.add(tv);
            titleList.add("第" + i + "页");
        }


        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };

        id_viewpager.setAdapter(pagerAdapter);
        id_indicator.setViewPager(id_viewpager);

    }

    public void toC(View v) {
        startActivity(new Intent(BActivity.this, CActivity.class));
//        finish();
    }

    public void finishB(View v) {
        this.setResult(222);
        finish();
    }
}