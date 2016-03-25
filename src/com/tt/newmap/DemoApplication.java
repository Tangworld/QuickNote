package com.tt.newmap;

import com.baidu.mapapi.SDKInitializer;

import android.app.Application;

public class DemoApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		SDKInitializer.initialize(this);
	}

}
