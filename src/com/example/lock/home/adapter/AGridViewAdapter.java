package com.example.lock.home.adapter;

import com.example.lock.R;
import com.example.lock.utils.ToastUtil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AGridViewAdapter extends BaseAdapter {

	private Context context;
	
	private HoldView holdView;
	
	private int[] imgs = new int[] {
		R.drawable.item_a1,	
		R.drawable.item_a2,	
		R.drawable.item_a3,	
		R.drawable.item_a4,	
		R.drawable.item_a5,	
		R.drawable.item_a6	
	};
	
	private String[] values = new String[] {
		"新手奖励活动",
		"待激活收益",
		"成功兑换",
		"压岁钱",
		"公告",
		"贺岁红包"
	};
	
	public AGridViewAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return imgs.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			holdView = new HoldView();
			convertView = LayoutInflater.from(context).inflate(R.layout.agridviewadapter, null);
			holdView.img = (ImageView) convertView.findViewById(R.id.agridviewadapter_img);
			holdView.tag = (ImageView) convertView.findViewById(R.id.agridviewadapter_tag);
			holdView.value = (TextView) convertView.findViewById(R.id.agridviewadapter_value);
			convertView.setTag(holdView);
		}else {
			holdView = (HoldView) convertView.getTag();
		}
		holdView.img.setImageResource(imgs[position]);
		holdView.value.setText(values[position]);
		if(position == 0||position ==5) {
			holdView.tag.setVisibility(View.VISIBLE);
		}else {
			holdView.tag.setVisibility(View.GONE);
		}
		final int p = position;
		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ToastUtil.showShortToast(context, values[p]);
			}
		});
		return convertView;
	}

	private class HoldView {
		ImageView img;
		ImageView tag;
		TextView value;
	}
	
}
