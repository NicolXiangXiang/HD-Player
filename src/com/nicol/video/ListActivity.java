package com.nicol.video;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class ListActivity extends FragmentActivity {

	TestFragmentAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;

	Button btnplay;
	Button btnsetting;
	
	View settingView;
	
	boolean setShow=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		btnplay=(Button)findViewById(R.id.btn_play);
		btnsetting=(Button)findViewById(R.id.btn_setting);
		settingView=(View)findViewById(R.id.settingView);
		mPager.setAdapter(mAdapter);

		CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mIndicator = indicator;
		indicator.setViewPager(mPager);
		indicator.setSnap(true);

		btnplay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListActivity.this,
						VideoPlayerActivity.class);
				ListActivity.this.startActivity(intent);
				
			}
		});
		btnsetting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(setShow){
					setShow=false;
					settingView.setVisibility(View.GONE);
				}else{
					setShow=true;
					settingView.setVisibility(View.VISIBLE);
				}
			}
		});
		
//		btn1.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(ListActivity.this,
//						VideoPlayerActivity.class);
//				ListActivity.this.startActivity(intent);
//			}
//		});
	}
}
