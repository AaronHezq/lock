package com.example.lock.home.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lock.R;

public class FragmentA extends Fragment {

	private Context context;

	private View view;

	private LayoutInflater inflater;

	private Button button;
	private ImageView lockImg;

	private float positionX, positionY;
	private float lockX, lockY;

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		context = getActivity();
		view = inflater.inflate(R.layout.fragment_a, null);
		button = (Button) view.findViewById(R.id.button1);
		lockImg = (ImageView) view.findViewById(R.id.lock_img);
		button.setOnTouchListener(new OnTouchListener() {
			private int mx;

			@Override
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
					} else {
						lockImg.setImageResource(R.drawable.lock_n);
					}
					break;
				case MotionEvent.ACTION_UP:
					lockImg.setImageResource(R.drawable.lock_n);
					button.layout((int) positionX, (int) positionY, (int) positionX + button.getWidth(),
							(int) positionY + button.getHeight());
					break;
				}
				return true;
			}
		});
		return view;
	}

}
