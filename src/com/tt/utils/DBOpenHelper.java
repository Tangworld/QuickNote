package com.tt.utils;

import org.junit.Test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper{

	/**
	 * 
	 * @param context 上下文对象
	 * @param name    数据库名称
	 * @param factory   不用管
	 * @param version   数据库版本号
	 */
	public DBOpenHelper(Context context) {
		super(context, "quicknote3.db", null, 1);
	}

	/**
	 * 创建数据库
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
//		db.execSQL("DROP TABLE person");
		db.execSQL("CREATE TABLE person(user varchar(20) primary key,pwd varchar(20))");
//		db.execSQL("DROP TABLE file");
		db.execSQL("CREATE TABLE contenttable(username varchar(20),password varchar(20),content varchar(300),latitude varchar(20),longitude varchar(20))");
		}

	/**
	 * 修改数据库表结构的方法
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
