package com.zhangxq.test.imageview;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zhangxq.refreshlayout.RefreshLayout;
import com.zhangxq.test.R;


/**
 * Created by zhangxiaoqi on 2019/4/18.
 */

public class ImageViewActivity extends AppCompatActivity implements RefreshLayout.OnRefreshListener, RefreshLayout.OnLoadListener {
    private RefreshLayout refreshLayout;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadListener(this);
        refreshLayout.setColorSchemeColors(0xffff0000, 0xff00ff00, 0xff0000ff);
        refreshLayout.setProgressBackgroundColorSchemeColor(0xffabcdef);

        imageView = findViewById(R.id.imageView);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setRotation(imageView.getRotation() + 180);
                refreshLayout.setRefreshing(false);
            }
        }, 5000);
    }

    @Override
    public void onLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setRotation(imageView.getRotation() + 180);
                refreshLayout.setLoading(false);
            }
        }, 1000);
    }
}
