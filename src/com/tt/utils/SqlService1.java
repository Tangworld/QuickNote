package com.tt.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tt.entity.Fc;
import com.tt.entity.Item;

public class SqlService1 {
	
	private Context context;
	
	public SqlService1(Context context){
		this.context=context;
	}
	

	public void save(String username,String password,String content,String latitude,String longitude){
		DBOpenHelper dbOpenHelper=new DBOpenHelper(context);
		SQLiteDatabase database=dbOpenHelper.getReadableDatabase();
		/*CREATE TABLE file(username varchar(20) primary key,password varchar(20),content varchar(300),latitude varchar(20),longitude varchar(20))*/
		String sql="insert into contenttable (username,password,content,latitude,longitude) values('"+username+"','"+password+"','"+content+"','"+latitude+"','"+longitude+"')";
		database.execSQL(sql);
		System.out.println("±£´æ³É¹¦£¡");
	}
	
	
	public void update (String sql){
		DBOpenHelper dbOpenHelper=new DBOpenHelper(context);
		SQLiteDatabase database=dbOpenHelper.getReadableDatabase();
		database.execSQL(sql);
	}

	public void delete (String sql){
		DBOpenHelper dbOpenHelper=new DBOpenHelper(context);
		SQLiteDatabase database=dbOpenHelper.getReadableDatabase();
		database.execSQL(sql);
	}
	
	public List<Item> findbysql(String sql){
    	List<Item> list=new ArrayList<Item>();
    	DBOpenHelper dbOpenHelper=new DBOpenHelper(context);
    	SQLiteDatabase db = dbOpenHelper.getReadableDatabase();//
    	Cursor cursor=db.rawQuery(sql, null);
//    	"select * from file "
    
    	while (cursor.moveToNext()) {
    		
    		/*username,password,content,latitude,longitude*/
    		
			 String username=cursor.getString(cursor.getColumnIndex("username"));
			 String password=cursor.getString(cursor.getColumnIndex("password"));
			 String content=cursor.getString(cursor.getColumnIndex("content"));
			 String latitude=cursor.getString(cursor.getColumnIndex("latitude"));
			 String longitude=cursor.getString(cursor.getColumnIndex("longitude"));
			 Item item=new Item(username,password,content,latitude,longitude);
			 list.add(item);
		}
    
		return list;
    	
    }
	

}
