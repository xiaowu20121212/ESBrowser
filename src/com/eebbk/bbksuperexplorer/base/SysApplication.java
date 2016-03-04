package com.eebbk.bbksuperexplorer.base;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

public class SysApplication extends Application implements UncaughtExceptionHandler{
	
	public static final String YCEXIT = "YCEXIT";
	public static final String ZCEXIT = "ZCEXIT";
	
	public static final String TAG = "SysApplication";

	private List<Activity> list = new LinkedList<Activity>();
	public void addActivity(Activity activity) {
		list.add(activity);

	}

	public void removeActivity(Activity activity) {
		if (activity != null) {
			list.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	public void exit(String flag) {
		try {
			for (Activity activity : list) {
				if (activity != null) {
					activity.finish();
				}
			}
		} catch (Exception e) {
		} finally {
			if (flag.equals(ZCEXIT)) {
				System.exit(0);
			} else {
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(0);
			}
		}

	}
	
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		doCrashReport(thread, ex);
	}

	private void doCrashReport(Thread thread, Throwable ex) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				Log.e(TAG,ex.getMessage());
			}

			exit(YCEXIT);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
//		 x.Ext.init(this);
//		 x.Ext.setDebug(true); // 是否输出debug日志
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}
}
