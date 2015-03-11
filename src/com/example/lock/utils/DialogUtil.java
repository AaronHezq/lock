package com.example.lock.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.lock.R;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * Dialog工具类
 * 
 * @author hzq
 * 
 */
public class DialogUtil {

	private static int[] images = { R.drawable.yq_img1, R.drawable.yq_img2, R.drawable.yq_img3, R.drawable.yq_img4,
			R.drawable.yq_img5, R.drawable.yq_img6 };
	private static String[] names = { "微信", "朋友圈", "短信", "QQ", "QQ空间", "二维码" };

	public static int CODE_1 = 1001;
	public static int CODE_2 = 1002;
	public static int CODE_3 = 1003;
	public static int CODE_4 = 1004;
	public static int CODE_5 = 1005;
	public static int CODE_6 = 1006;

	public static void showYQ(final Context context, final Handler handler) {
		View view = LayoutInflater.from(context).inflate(R.layout.dialog_yq, null);
		ListView listView = (ListView) view.findViewById(R.id.dialog_listview);
		listView.setAdapter(new YQAdapter(context, names, images));
		final Dialog dialog = new Dialog(context);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				handler.sendEmptyMessage(position + 1001);
				dialog.dismiss();
				ToastUtil.showShortToast(context, names[position]);
			}
		});
		dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(view);
		dialog.show();
	}

}
