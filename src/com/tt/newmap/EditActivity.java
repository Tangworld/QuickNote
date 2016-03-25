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

public class EditActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		System.out.println("进入编辑页面！");
		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try{
					Intent intent=new Intent(EditActivity.this, MainActivity.class);
					EditText editText2=(EditText) findViewById(R.id.filecontext);
					
		/*			CREATE TABLE file(username varchar(20) primary key,password varchar(20),content varchar(300),latitude varchar(20),longitude varchar(20))*/
					String username=getIntent().getStringExtra("username");
					String password=getIntent().getStringExtra("password");
					String latitude=getIntent().getStringExtra("latitude");
					String longitude=getIntent().getStringExtra("longitude");
					System.out.println("editactivity"+latitude+"   "+longitude);
					SqlService1 service1=new SqlService1(getApplicationContext());
					service1.save(username,password,editText2.getText().toString(),latitude,longitude);
					System.out.println(username+"1");
					Toast.makeText(getApplicationContext(), "保存成功", 1).show();
					intent.putExtra("username", username);
					System.out.println(username+"2");
					/*List<Item> items=new ArrayList<Item>();
					items=service1.findbysql("select * from contenttable where password="+password);
					for(Item i:items){
						String latitude2 = i.getLatitude();
						String longitude2 = i.getLongitude();
						System.out.println("username"+i.getUsername());
						System.out.println("password"+i.getPassword());
						System.out.println("EditActivity----->latitude:"+latitude2+"   longitude:"+longitude2);
					}*/
					startActivity(intent);
					System.out.println(username+"3");
				}catch(Exception e){
					Toast.makeText(getApplicationContext(), "保存失败", 1).show();
				}
			}
		});
		
	}
	

}
