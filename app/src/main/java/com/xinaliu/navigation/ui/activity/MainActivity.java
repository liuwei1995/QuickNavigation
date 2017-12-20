package com.xinaliu.navigation.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.xinaliu.navigation.R;
import com.xinaliu.navigation.ui.adapter.TabFragmentAdapter;
import com.xinaliu.navigation.ui.fragment.AndroidFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpaer_oder);
        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
        List<String> lists = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();

        lists.add("Android");
        lists.add("Android");
        lists.add("Android");

        fragments.add(AndroidFragment.newInstance(false));
        fragments.add(AndroidFragment.newInstance(true));
        fragments.add(AndroidFragment.newInstance(true));

        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(fragments, lists, getSupportFragmentManager(), this);
        viewPager.setAdapter(fragmentAdapter);
        // 初始化
        // 将ViewPager和TabLayout绑定
        tablayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(fragments.size());
    }
}
