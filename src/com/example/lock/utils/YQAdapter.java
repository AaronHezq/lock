package com.example.lock.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lock.R;

public class YQAdapter extends BaseAdapter {
	private static int[] images;
	private static String[] names;

	private HoldView holdView;
	private Context context;

	public YQAdapter(Context context, String[] names, int[] images) {
		this.context = context;
		this.images = images;
		this.names = names;
	}

	@Override
	public int getCount() {
		return images.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			holdView = new HoldView();
			convertView = LayoutInflater.from(context).inflate(R.layout.dialog_yq_item, null);
			holdView.img = (ImageView) convertView.findViewById(R.id.dialog_yq_item_img);
			holdView.value = (TextView) convertView.findViewById(R.id.dialog_yq_item_value);
			convertView.setTag(holdView);
		} else {
			holdView = (HoldView) convertView.getTag();
		}
		holdView.img.setImageResource(images[position]);
		holdView.value.setText(names[position]);
		return convertView;
	}

	private class HoldView {
		ImageView img;
		TextView value;
	}

}
