package com.example.lock.home;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.lock.R;
import com.example.lock.home.fragment.FragmentA;
import com.example.lock.home.fragment.FragmentB;
import com.example.lock.home.fragment.FragmentC;
import com.example.lock.home.fragment.FragmentD;
import com.example.lock.utils.DialogUtil;
import com.example.lock.utils.ToastUtil;


/**
 * 主界面
 * @author Aaron He
 *
 */
public class HomeActivity extends FragmentActivity {

	private FragmentA f1;
	private FragmentB f2;
	private FragmentC f3;
	private FragmentD f4;
	
	private final static int INDEX_1 = 1;
	private final static int INDEX_2 = 2;
	private final static int INDEX_3 = 3;
	private final static int INDEX_4 = 4;
	
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			
		};
	};
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.home_main);
		Intent intent = new Intent("com.example.lock.service.myservice");
		startService(intent);
		initData();
		changeBg(1);
	}
	
	
	public void initData() {
		if(f1 ==null) {
			f1 = new FragmentA();
		}
		addFragmentToStack(INDEX_1);
	}
	
	/**
	 * 将页面内容显示到界面上
	 * 
	 * @param position
	 */
	private void addFragmentToStack(int position) {
		try {
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			switch (position) {
			case INDEX_1:
				if (f1.isAdded()) {
					ft.show(f1);
					if (f2 != null && f2.isAdded()) {
						ft.hide(f2);
					}
					if (f3 != null && f3.isAdded()) {
						ft.hide(f3);
					}
					if (f4 != null && f4.isAdded()) {
						ft.hide(f4);
					}
				} else {
					ft.add(R.id.home_content, f1);
				}
				break;
			case INDEX_2:
				if (f2.isAdded()) {
					ft.show(f2);
					if (f1 != null && f1.isAdded()) {
						ft.hide(f1);
					}
					if (f3 != null && f3.isAdded()) {
						ft.hide(f3);
					}
					if (f4 != null && f4.isAdded()) {
						ft.hide(f4);
					}
				} else {
					ft.add(R.id.home_content, f2);
				}
				break;
			case INDEX_3:
				if (f3.isAdded()) {
					ft.show(f3);
					if (f1 != null && f1.isAdded()) {
						ft.hide(f1);
					}
					if (f2 != null && f2.isAdded()) {
						ft.hide(f2);
					}
					if (f4 != null && f4.isAdded()) {
						ft.hide(f4);
					}
				} else {
					ft.add(R.id.home_content, f3);
				}
				break;
			case INDEX_4:
				if (f4.isAdded()) {
					ft.show(f4);
					if (f1 != null && f1.isAdded()) {
						ft.hide(f1);
					}
					if (f3 != null && f3.isAdded()) {
						ft.hide(f3);
					}
					if (f2 != null && f2.isAdded()) {
						ft.hide(f2);
					}
				} else {
					ft.add(R.id.home_content, f4);
				}
				break;
			}
			ft.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 立即邀请
	 * @param view
	 */
	public void invite(View view) {
		DialogUtil.showYQ(this, handler);
	}
	
	/**
	 * 一键获取邀请码
	 * @param view
	 */
	public void getCode(View view) {
		ToastUtil.showShortToast(this, "一键获取邀请码");
	}
	
	/**
	 * 更多，item点击事件
	 * @param v
	 */
	public void selectSetItem(View v) {
		switch (v.getId()) {
		case R.id.setting_item_1://锁屏设置
			ToastUtil.showShortToast(this, "锁屏设置");
			break;
		case R.id.setting_item_2://我的账户
			ToastUtil.showShortToast(this, "我的账户");
			break;
		case R.id.setting_item_3://我的下载
			ToastUtil.showShortToast(this, "我的下载");
			break;
		case R.id.setting_item_4://流量控制
			ToastUtil.showShortToast(this, "流量控制");
			break;
		case R.id.setting_item_5://关于锁屏
			ToastUtil.showShortToast(this, "关于锁屏");
			break;
		}
	}
	
	
	/**
	 * 底部点击事件
	 */
	public void selectbar(View view) {
		int position = 0;
		switch (view.getId()) {
		case R.id.home_bottom_btn_1:// 收益
			position = 0;
			if (f1 == null)
				f1 = new FragmentA();
			addFragmentToStack(INDEX_1);
			break;
		case R.id.home_bottom_btn_2:// 兑换
			position = 1;
			if (f2 == null)
				f2 = new FragmentB();
			addFragmentToStack(INDEX_2);
			break;
		case R.id.home_bottom_btn_3:// 邀请
			position = 2;
			if (f3 == null)
				f3 = new FragmentC();
			addFragmentToStack(INDEX_3);
			break;
		case R.id.home_bottom_btn_4:// 更多
			position = 3;
			if (f4 == null)
				f4 = new FragmentD();
			addFragmentToStack(INDEX_4);
			break;
		}
		changeBg(position + 1);
	}
	
	/**
	 * 改变底部点击颜色
	 */
	@SuppressLint("ResourceAsColor")
	public void changeBg(int position) {
		switch (position) {
		case 1:
			findViewById(R.id.home_bottom_btn_bg1).setBackgroundColor(0);
			findViewById(R.id.home_bottom_btn_bg2).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg3).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg4).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_1).setBackgroundResource(R.drawable.tabbar_selected);
			findViewById(R.id.home_bottom_btn_2).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_3).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_4).setBackgroundResource(0);
			break;
		case 2:
			findViewById(R.id.home_bottom_btn_bg1).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg2).setBackgroundColor(0);
			findViewById(R.id.home_bottom_btn_bg3).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg4).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_1).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_2).setBackgroundResource(R.drawable.tabbar_selected);
			findViewById(R.id.home_bottom_btn_3).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_4).setBackgroundResource(0);
			break;
		case 3:
			findViewById(R.id.home_bottom_btn_bg1).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg2).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg3).setBackgroundColor(0);
			findViewById(R.id.home_bottom_btn_bg4).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_1).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_2).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_3).setBackgroundResource(R.drawable.tabbar_selected);
			findViewById(R.id.home_bottom_btn_4).setBackgroundResource(0);
			break;
		case 4:
			findViewById(R.id.home_bottom_btn_bg1).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg2).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg3).setBackgroundColor(R.color.clear_70);
			findViewById(R.id.home_bottom_btn_bg4).setBackgroundColor(0);
			findViewById(R.id.home_bottom_btn_1).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_2).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_3).setBackgroundResource(0);
			findViewById(R.id.home_bottom_btn_4).setBackgroundResource(R.drawable.tabbar_selected);
			break;
		}
	}
	
}
