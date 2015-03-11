package com.example.lock.home.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lock.R;
/**
 * 收益页面
 * @author hzq
 *
 */
public class FragmentA extends Fragment {

	private Context context;

	private View view;

	private LayoutInflater inflater;

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		context = getActivity();
		view = inflater.inflate(R.layout.fragment_a, null);
		return view;
	}

}
