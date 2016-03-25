package com.tt.newmap;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tt.entity.Person;
import com.tt.utils.SqlService;

public class SQLiteLoginActivity extends Activity{
	private Button rebutton;
	private Button lobutton;

	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_login);
//	        DBOpenHelper dbOpenHelper=new DBOpenHelper(getApplicationContext());
//	        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
//	        dbOpenHelper.onCreate(db);
	        rebutton = (Button) findViewById(R.id.btnReg);
	        lobutton = (Button) findViewById(R.id.btnLogin);
	        rebutton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(SQLiteLoginActivity.this,SQLiteRegistActivity.class);
					startActivity(intent);
				}
			});
	        lobutton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(getApplicationContext(),MainActivity.class);
			    	EditText editText=(EditText) findViewById(R.id.etUid);
			    	EditText editText2=(EditText) findViewById(R.id.etPwd);
			    	String username=editText.getText().toString();
			    	String password=editText2.getText().toString();
			    	SqlService service=new SqlService(getApplicationContext());
			    	List<Person> list=service.findbysql("");
			    	if (!username.equals("")) {
						if (!password.equals("")) {
							if (list.size()!=0) {
								for (int i = 0; i < list.size(); i++) {
						    		String user1=list.get(i).getUser();
						    		String pwd1=list.get(i).getPwd();
						    		if (username.equals(user1)) {
										if (password.equals(pwd1)) {
											intent.putExtra("username",username);
											intent.putExtra("password", password);
											startActivity(intent);
											Toast.makeText(getApplicationContext(), "µÇÂ¼³É¹¦", 1).show();
											break;
										} else {
											Toast.makeText(getApplicationContext(), "ÃÜÂë´íÎó", 1).show();
											break;
										}
									} else {
									}
								}
							} else {
								Toast.makeText(getApplicationContext(), "±¾»úÃ»ÓÐÕËºÅ£¬Çë×¢²á", 1).show();
							}
							
						} else {
							Toast.makeText(getApplicationContext(), "ÇëÊäÈëÃÜÂë", 1).show();
						}
					} else {
						Toast.makeText(getApplicationContext(), "ÇëÊäÈëÕËºÅ", 1).show();
					}
				}
			});
	       
	    }
	    
	    
}
