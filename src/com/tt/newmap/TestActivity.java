package com.tt.newmap;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

public class TestActivity extends Activity{
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		button=(Button) findViewById(R.id.button);
		
	}
	

}
