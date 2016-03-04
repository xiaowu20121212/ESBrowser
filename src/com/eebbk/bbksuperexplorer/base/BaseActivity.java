package com.eebbk.bbksuperexplorer.base;

import com.eebbk.bbksuperexplorer.util.DBUtil;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity {

	private DBUtil mDBUtil=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		((SysApplication) getApplication()).addActivity(this);
		super.onCreate(savedInstanceState);
		iniSelfParam();
		initView();
		initData();
		initEvent();
	}

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {

			case Toast.LENGTH_LONG:
				Toast.makeText(BaseActivity.this, (String) msg.obj,
						Toast.LENGTH_LONG).show();
				break;
			case Toast.LENGTH_SHORT:
				Toast.makeText(BaseActivity.this, (String) msg.obj,
						Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
			super.handleMessage(msg);
		}

	};

	protected void showToastLong(CharSequence text) {
		Message message = handler.obtainMessage();
		message.obj = text;
		message.what = Toast.LENGTH_LONG;
		handler.sendMessage(message);
	}

	protected void showToastShort(CharSequence text) {
		Message message = handler.obtainMessage();
		message.obj = text;
		message.what = Toast.LENGTH_SHORT;
		handler.sendMessage(message);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		((SysApplication) getApplication()).removeActivity(this);

	}
	private void iniSelfParam(){
		mDBUtil=DBUtil.getInstance(this);
	}
	 /**
	  *  得到状态栏的高度
	  * @return
	  */
    public int getStateBar() {
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        return statusBarHeight;
    }
 
    /**
     *  dip到px的转化
     * @param context 上下文
     * @param dipValue 需要转换的值
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (scale * dipValue + 0.5f);
    }
    public DBUtil getDBUitl(){
    	return mDBUtil;
    }

	/**
	 * 初始化控件操作
	 */
	public abstract void initView() ;

	/**
	 * 初始化数据操作
	 */
	public abstract void initData();
	
	
	/**
	 * 初始化事件操作
	 */
	public abstract void initEvent(); 
}
