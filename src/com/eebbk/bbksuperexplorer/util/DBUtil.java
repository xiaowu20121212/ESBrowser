package com.eebbk.bbksuperexplorer.util;

import java.util.ArrayList;
import java.util.List;

import com.eebbk.bbksuperexplorer.bean.BaseEntity;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import android.content.Context;

public class DBUtil {
	public static final String DB_DIR="/data/data/com.eebbk.esbrowser/databases/";
	public static final String DB_NAME="ESBrower_database";
	private DbUtils mDbUtils=null;
	private Context mContex=null;
	private static DBUtil mDBUtil=null;
	/**
	 * 单例模式获取数据操作对象
	 * @param context
	 * @return
	 */
	public static synchronized DBUtil getInstance(Context context){
		if(mDBUtil==null){
			mDBUtil=new DBUtil(context.getApplicationContext());
		}
		return mDBUtil;
	}
	private DBUtil(Context context){
		mContex=context;
		mDbUtils=DbUtils.create(mContex, DB_DIR, DB_NAME);
	}
	public void save(BaseEntity entity) {
		if(entity!=null){
			try {
				mDbUtils.save(entity);
			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update(BaseEntity entity){
		if(entity!=null){
			try {
				mDbUtils.replace(entity);
			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void delete(BaseEntity entity){
		if(entity!=null){
			try {
				mDbUtils.delete(entity);
			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public <T> List<T>  findAll(Class<T> cls){
		List<T> list=null;
		try {
			List<T> temp=mDbUtils.findAll(cls);
			list=temp!=null?temp:new ArrayList<T>();
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
