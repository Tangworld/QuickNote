package com.tt.newmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tt.utils.SqlService;

public class SQLiteRegistActivity extends Activity {
	private String username;
	private String password;
	private Button rebutton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		rebutton = (Button) findViewById(R.id.registbutton);
		rebutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				EditText editText = (EditText) findViewById(R.id.reusername);
				EditText editText2 = (EditText) findViewById(R.id.repassword);
				username = editText.getText().toString();
				password = editText2.getText().toString();
				if (username.equals("") || password.equals("")) {
					Toast.makeText(getApplicationContext(), "ÕËºÅÃÜÂë²»ÄÜÎª¿Õ", 1)
							.show();
				} else {
					try {
						SqlService service = new SqlService(
								getApplicationContext());
						service.savezc(editText.getText().toString(), editText2
								.getText().toString());
						Toast.makeText(getApplicationContext(), "×¢²á³É¹¦", 1)
								.show();
						Intent intent = new Intent(getApplicationContext(),
								SQLiteLoginActivity.class);
						startActivity(intent);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), "×¢²áÊ§°Ü", 1)
								.show();
						System.out.println(e);
					}
				}
			}
		});

	}
}
