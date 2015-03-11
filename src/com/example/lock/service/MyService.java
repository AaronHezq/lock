package com.example.lock.service;

import com.example.lock.broadcast.ScreenBroadCast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

	ScreenBroadCast broadCast;
	
	private final IBinder binder = new MyBinder();

	public class MyBinder extends Binder {
		MyService getService() {
			return MyService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

	@Override
	public void onCreate() {
		broadCast = new ScreenBroadCast();
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		registerReceiver(broadCast, filter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy(); // 可以不用
	}

}