package com.tt.newmap;
/**
 * ʵ�ֵ�¼����   


 */
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.tt.newmap.R;
import com.tt.newmap.R.id;
import com.tt.newmap.R.layout;
import com.tt.utils.DialogUtil;
import com.tt.utils.HttpUtil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {

	
	EditText ed,ed1;
	protected ProgressDialog pd;
	boolean result;
	public void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//final ProgressDialog pd;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Button btnReg=(Button)findViewById(R.id.btnReg);
		btnReg.setOnClickListener(new View.OnClickListener() {//Ϊע����Ӱ���������
		
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			
				finish(); //��������ע���Activity
			}
		});
		Button btnLogin = (Button)findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ed = (EditText)findViewById(R.id.etUid);
				ed1 = (EditText)findViewById(R.id.etPwd);
				boolean flag = true;
				boolean flag2=true;
				if(TextUtils.isEmpty(ed.getText())){
					Toast.makeText(LoginActivity.this, "�˺Ų���Ϊ��", Toast.LENGTH_LONG).show();
					flag=false;
				}
				if(TextUtils.isEmpty(ed1.getText())&&flag==true){
					Toast.makeText(LoginActivity.this, "���벻��Ϊ��", Toast.LENGTH_LONG).show();
					flag2=false;
				}
				if(flag==true&&flag2==true){
					if(login()){//����¼	
						pd= ProgressDialog.show(LoginActivity.this, "���Ժ�", "�������ӷ���������",true,true);
						Intent inten = new Intent(LoginActivity.this,MainActivity.class);
						startActivity(inten);
						finish();
					}
					else {
						DialogUtil.showDialog(LoginActivity.this, "�˺Ż�����������������룡", false);
					}
				}
			}
		});
		
	}

	private boolean login() {
		String uid=ed.getText().toString();
		String pwd=ed1.getText().toString();
		String id = ed.getEditableText().toString().trim();
		JSONObject jsonObj;
		try{
			jsonObj = query(uid,pwd);
			if(jsonObj.get("result").equals("��¼�ɹ�")){
				return true;
			}
		}
		catch(Exception e){
			//���÷�����ʾ����
			DialogUtil.showDialog(LoginActivity.this, "��������Ӧ�쳣�����Ժ����ԣ�", false);
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub
		
	}
	private JSONObject query(String uid, String pwd)throws Exception {
		// TODO Auto-generated method stub
		Map<String ,String> map=new HashMap<String ,String>();
		map.put("name", uid);
		map.put("password", pwd);
		String url = HttpUtil.getBaseLoginurl();
		String str =HttpUtil.postRequest(url, map);
		JSONObject js =  new JSONObject(str);
		return js;
	}
	
}

