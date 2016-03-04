package com.eebbk.bbksuperexplorer.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

	private ArrayList<Fragment> data=null;
	public BaseFragmentPagerAdapter(FragmentManager fm,ArrayList< Fragment> list) {
		super(fm);
		// TODO Auto-generated constructor stub
		data=list;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

}
