package com.tt.utils;

import java.util.ArrayList;
import java.util.List;

import com.tt.entity.Fc;
import com.tt.entity.Person;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class SqlService {

	private Context context;

	public SqlService(Context context) {
		this.context = context;
	}

	public void savezc(String user, String pwd) {
		DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
		SQLiteDatabase database = dbOpenHelper.getReadableDatabase();
		String sql = "insert into person (user,pwd) values('" + user + "','"
				+ pwd + "')";
		database.execSQL(sql);
	}

	public List<Person> findbysql(String sql) {
		List<Person> list = new ArrayList<Person>();
		DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from person ", null);

		while (cursor.moveToNext()) {

			String person1 = cursor.getString(cursor.getColumnIndex("user"));
			String pwd1 = cursor.getString(cursor.getColumnIndex("pwd"));
			Person personlist = new Person(person1, pwd1);
			list.add(personlist);
		}

		return list;

	}

}
