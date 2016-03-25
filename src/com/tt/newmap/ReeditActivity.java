package com.tt.newmap;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tt.entity.Item;
import com.tt.utils.SqlService1;

public class ReeditActivity extends Activity {
	
	private Button updatebutton;
	private Button deletebutton;
	private Button backbutton;
	private String username;
	private String password;
	private String latitude;
	private String longitude;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reedit);
		Intent intent = getIntent();
		username=intent.getStringExtra("username");
		password=intent.getStringExtra("password");
		latitude=intent.getStringExtra("latitude");
		longitude=intent.getStringExtra("longitude");
		//从数据库中取出数据，还原前面编辑过的内容
		List<Item> items = new ArrayList<Item>();
		items=getData(password,latitude,longitude);
		System.out.println("reedit!");
		System.out.println(username);
		System.out.println(password);
		System.out.println(latitude);
		System.out.println(longitude);
		for(Item i:items){
			String content = i.getContent();
			System.out.println("reedit:    "+i.getUsername());
			System.out.println("reedit:    "+i.getPassword());
			System.out.println("reedit:    "+i.getLatitude());
			System.out.println("reedit:    "+i.getLongitude());
			System.out.println("reedit:    "+i.getContent());
			EditText editText2 = (EditText) findViewById(R.id.filecontext1);
			editText2.setText(content);
		}
		//给各个按钮设置监听器
		updatebutton = (Button)findViewById(R.id.updatebutton);
		deletebutton = (Button)findViewById(R.id.deletebutton);
		backbutton = (Button)findViewById(R.id.backbutton);
		
		updatebutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				update();
			}
		});
		
		deletebutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				delete();
			}
		});
		
		backbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				back();
			}
		});
		
	}

	public void back() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		intent.putExtra("username", getIntent().getStringExtra("username"));
		intent.putExtra("password", getIntent().getStringExtra("password"));
		startActivity(intent);
	}

	public void update() {
		EditText editText2 = (EditText) findViewById(R.id.filecontext1);
		String content = editText2.getText().toString();
		SqlService1 service = new SqlService1(getApplicationContext());
		service.delete("delete from contenttable where latitude='" + latitude + "' and longitude='" + longitude+"'");
		try {
			service.save(username,password,content,latitude,longitude);
			Toast.makeText(getApplicationContext(), "修改成功", 1).show();
			Intent intent = new Intent(getApplicationContext(),
					MainActivity.class);
			intent.putExtra("username", username);
			intent.putExtra("password", password);
			startActivity(intent);
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "标题重复", 1).show();
		}
	}

	public void delete() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		SqlService1 service = new SqlService1(getApplicationContext());
		service.delete("delete from contenttable where latitude='" + latitude + "' and longitude='" + longitude+"'");
		Toast.makeText(getApplicationContext(), "删除成功", 1).show();
		intent.putExtra("username", username);
		intent.putExtra("password", password);
		startActivity(intent);
	}

	private List<Item> getData(String password, String latitude,
			String longitude) {
		String sql = "select * from contenttable where latitude='" + latitude
				+ "' and longitude='" + longitude + "' and password='" + password+"'";
		List<Item> items = new ArrayList<Item>();
		SqlService1 query = new SqlService1(getApplicationContext());
		items = query.findbysql(sql);
		return items;
	}
}
