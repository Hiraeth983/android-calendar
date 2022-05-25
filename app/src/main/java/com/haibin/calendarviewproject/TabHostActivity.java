package com.haibin.calendarviewproject;


import androidx.appcompat.app.AppCompatActivity;


import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import com.haibin.calendarviewproject.full.FullActivity;
import com.haibin.calendarviewproject.meizu.MeiZuActivity;
import com.haibin.calendarviewproject.mix.MixActivity;


public class TabHostActivity extends ActivityGroup {
    private TabHost mytabHost; //定义TabHost
    private int[] layRes = {R.layout.activity_full, R.layout.activity_meizu, R.layout.activity_mix, R.layout.activity_main};//定义内嵌布局管理器ID
    private Button openButton, save, saveAs, copy, paste, seekbut1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost); //调用默认布局管理器
        mytabHost = findViewById(R.id.tabhost);//取得TabHost对象
        mytabHost.setup(getLocalActivityManager()); //建立TabHost对象
        mytabHost.addTab(mytabHost.newTabSpec("tab1")
                .setIndicator("full1")
                .setContent(new Intent(this, FullActivity.class)));

        mytabHost.addTab(mytabHost.newTabSpec("tab2")
                .setIndicator("meizu")
                .setContent(new Intent(this, MeiZuActivity.class)));
        mytabHost.addTab(mytabHost.newTabSpec("tab3")
                .setIndicator("mix")
                .setContent(new Intent(this, MixActivity.class)));
        mytabHost.addTab(mytabHost.newTabSpec("tab4")
                .setIndicator("main")
                .setContent(new Intent(this, MainActivity.class)));
        mytabHost.setCurrentTab(1);


    }
}

