package com.example.lock.home.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lock.R;


public class FragmentD extends Fragment {

	private Context context;

	private View view;

	private LayoutInflater inflater;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		context = getActivity();
		view = inflater.inflate(R.layout.fragment_d, null);
		return view;
	}

	
}
