package com.eebbk.bbksuperexplorer.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	// 根部view
	private View mContentView;
	private Boolean hasInitData = false;
	private int mContentViewResID;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		initView();
		setContentView(inflater, mContentViewResID);
		return mContentView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		if (!hasInitData) {
			initData();
			initEvent();
			hasInitData = true;
		}
	}

	private View setContentView(LayoutInflater inflater, int layoutResID) {
		if (mContentView == null) {
			mContentView = inflater.inflate(layoutResID, null);
		}
		return mContentView;
	}

	public void setContentView(int layoutResID) {
		mContentViewResID = layoutResID;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		((ViewGroup) mContentView.getParent()).removeView(mContentView);
	}

	/**
	 * 初始化控件操作
	 */
	public abstract void initView();

	/**
	 * 初始化数据操作
	 */
	public abstract void initData();

	/**
	 * 初始化事件操作
	 */
	public abstract void initEvent();

}
