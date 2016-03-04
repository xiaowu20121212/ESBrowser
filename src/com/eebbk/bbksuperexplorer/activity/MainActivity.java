package com.eebbk.bbksuperexplorer.activity;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import com.eebbk.bbksuperexplorer.adapter.BaseFragmentPagerAdapter;
import com.eebbk.bbksuperexplorer.base.BaseActivity;
import com.eebbk.bbksuperexplorer.fragment.MainFragment;
import com.eebbk.bbksuperexplorer.fragment.MenuLeftFragment;
import com.eebbk.bbksuperexplorer.fragment.MenuRightFragment;
import com.eebbk.esbrowser.R;

public class MainActivity extends BaseActivity {

	private DrawerLayout mDrawerLayout;
	private ViewPager mViewPager;
	private BaseFragmentPagerAdapter mAdapter;
	private ArrayList<Fragment> mList;
	

	public void initView() {
		setContentView(R.layout.activity_main);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mViewPager = (ViewPager) findViewById(R.id.content_show);
	}

	public void initData() {
		mList=new ArrayList<Fragment>();
		Fragment one=new MenuLeftFragment();
		Fragment two=new MenuRightFragment();
		Fragment main=new MainFragment();
		Fragment one1=new MenuLeftFragment();
		Fragment two1=new MenuRightFragment();
		Fragment main1=new MainFragment();
		Fragment one2=new MenuLeftFragment();
		Fragment two2=new MenuRightFragment();
		Fragment main2=new MainFragment();
		Fragment one3=new MenuLeftFragment();
		Fragment two3=new MenuRightFragment();
		Fragment main3=new MainFragment();
		Fragment one4=new MenuLeftFragment();
		Fragment two4=new MenuRightFragment();
		Fragment main4=new MainFragment();
		Fragment one5=new MenuLeftFragment();
		Fragment two5=new MenuRightFragment();
		Fragment main5=new MainFragment();
		mList.add(main);
		mList.add(one);
		mList.add(two);
		mList.add(main1);
		mList.add(one1);
		mList.add(two1);
		mList.add(main2);
		mList.add(one2);
		mList.add(two2);
		mList.add(main3);
		mList.add(one3);
		mList.add(two3);
		mList.add(main4);
		mList.add(one4);
		mList.add(two4);
		mList.add(main5);
		mList.add(one5);
		mList.add(two5);
		
		mAdapter=new BaseFragmentPagerAdapter(getSupportFragmentManager(), mList);
		mViewPager.setAdapter(mAdapter);
	}

	public void initEvent() {
		
		
	}

	public void OpenRightMenu(View view) {
		mDrawerLayout.openDrawer(Gravity.RIGHT);
		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
				Gravity.RIGHT);
	}

}
