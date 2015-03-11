package com.example.lock;

import java.util.ArrayList;

import com.example.lock.view.JellyViewPager;
import com.example.lock.view.TestFragPagerAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class LockActivity extends FragmentActivity {

	private JellyViewPager viewPager;
	
	private Button button;
	private ImageView lockImg;

	private float positionX, positionY;
	private float lockX, lockY;
	private boolean unLock = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		setContentView(R.layout.activity_lock);
		viewPager = (JellyViewPager) findViewById(R.id.myViewPager1);
		viewPager.setAdapter(new TestFragPagerAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int state) {
				switch(state){
				case 1: //正在滑动
					break;
				case 2: //滑动结束
					break;
				}
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageSelected(int arg0) {
			}
			
		});
		init();
	}

	public void init() {
		button = (Button) findViewById(R.id.button1);
		lockImg = (ImageView) findViewById(R.id.lock_img);
		button.setOnTouchListener(new OnTouchListener() {
			private int mx;

			@SuppressLint("NewApi") @Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					if (positionX == 0 || positionY == 0) {
						positionX = button.getX();
						positionY = button.getY();
						lockX = lockImg.getX();
						lockY = lockImg.getY();
					}
					break;
				case MotionEvent.ACTION_MOVE:
					mx = (int) (event.getRawX());
					button.layout(mx - button.getWidth() / 2, (int) positionY, mx + button.getWidth() / 2, (int) positionY
							+ button.getHeight());
					if (lockX - mx < lockImg.getWidth()) {
						lockImg.setImageResource(R.drawable.lock_y);
						unLock = true;
					} else {
						
						unLock = false;
						lockImg.setImageResource(R.drawable.lock_n);
					}
					break;
				case MotionEvent.ACTION_UP:
					if(unLock) {
						finish();
						break;
					}
					lockImg.setImageResource(R.drawable.lock_n);
					button.layout((int) positionX, (int) positionY, (int) positionX + button.getWidth(),
							(int) positionY + button.getHeight());
					if(unLock) {
						finish();
					}
					break;
				}
				return true;
			}
		});
	}
	
	public void unLock(View view) {
		finish();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
