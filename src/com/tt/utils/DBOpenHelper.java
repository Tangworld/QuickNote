package com.tt.utils;

import org.junit.Test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper{

	/**
	 * 
	 * @param context �����Ķ���
	 * @param name    ���ݿ�����
	 * @param factory   ���ù�
	 * @param version   ���ݿ�汾��
	 */
	public DBOpenHelper(Context context) {
		super(context, "quicknote3.db", null, 1);
	}

	/**
	 * �������ݿ�
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
	 * �޸����ݿ��ṹ�ķ���
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
