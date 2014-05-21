package com.nicol.video;

import java.util.ArrayList;
import java.util.List;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableRow;

public class ListActivity extends FragmentActivity {

	TestFragmentAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;

	Button btnplay;
	Button btnsetting;

	View settingView;

	TableRow tRow1;
	TableRow tRow2;
	TableRow tRow3;

	List<Movie> listMovies;

	boolean setShow = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		InitData();

		mAdapter = new TestFragmentAdapter(getSupportFragmentManager());
		mPager = (ViewPager) findViewById(R.id.pager);
		btnplay = (Button) findViewById(R.id.btn_play);
		btnsetting = (Button) findViewById(R.id.btn_setting);
		settingView = (View) findViewById(R.id.settingView);
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
				if (setShow) {
					setShow = false;
					settingView.setVisibility(View.GONE);
				} else {
					setShow = true;
					settingView.setVisibility(View.VISIBLE);
				}
			}
		});
	}

	private void InitView() {
		for (int i = 0; i < listMovies.size(); i++) {
			if (i % 3 == 0) {
				tRow1.addView(LayoutInflater.from(this).inflate(R.layout.list_item, null));
			} else if (i % 3 == 1) {
				tRow1.addView(LayoutInflater.from(this).inflate(R.layout.list_item, null));
			} else if (i % 3 == 2) {
				tRow1.addView(LayoutInflater.from(this).inflate(R.layout.list_item, null));
			}
		}
	}

	private void InitData() {
		listMovies = new ArrayList<ListActivity.Movie>();
		Movie m1 = new Movie();
		m1.url = "";
		m1.imageUrl = "";
		m1.popUrl = "";
		listMovies.add(m1);

		Movie m2 = new Movie();
		m2.url = "";
		m2.imageUrl = "";
		m2.popUrl = "";
		listMovies.add(m2);

		Movie m3 = new Movie();
		m3.url = "";
		m3.imageUrl = "";
		m3.popUrl = "";
		listMovies.add(m3);

		Movie m4 = new Movie();
		m4.url = "";
		m4.imageUrl = "";
		m4.popUrl = "";
		listMovies.add(m1);

		Movie m5 = new Movie();
		m5.url = "";
		m5.imageUrl = "";
		m5.popUrl = "";
		listMovies.add(m5);

		Movie m6 = new Movie();
		m6.url = "";
		m6.imageUrl = "";
		m6.popUrl = "";
		listMovies.add(m6);

		Movie m7 = new Movie();
		m7.url = "";
		m7.imageUrl = "";
		m7.popUrl = "";
		listMovies.add(m7);

		Movie m8 = new Movie();
		m8.url = "";
		m8.imageUrl = "";
		m8.popUrl = "";
		listMovies.add(m8);

		Movie m9 = new Movie();
		m9.url = "";
		m9.imageUrl = "";
		m9.popUrl = "";
		listMovies.add(m9);

	}

	public class Movie {
		public String url = "";
		public String imageUrl = "";
		public String popUrl = "";
	}
}
