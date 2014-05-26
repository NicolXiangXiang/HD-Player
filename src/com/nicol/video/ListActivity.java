package com.nicol.video;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint.Join;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;

public class ListActivity extends FragmentActivity {

	TestFragmentAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;

	Button btnplay;
	Button btnsetting;

	Button btnOk;
	Button btnCancel;

	View settingView;

	TableRow tRow1;
	TableRow tRow2;
	TableRow tRow3;

	List<Movie> listMovies;

	List<Movie> checkListMovies;

	boolean setShow = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		checkListMovies = new ArrayList<ListActivity.Movie>();

		InitData();

		InitView();

		btnplay = (Button) findViewById(R.id.btn_play);
		btnsetting = (Button) findViewById(R.id.btn_setting);
		settingView = (View) findViewById(R.id.settingView);

		btnOk = (Button) findViewById(R.id.btn_ok);
		btnCancel = (Button) findViewById(R.id.btn_cancel);

		btnplay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (checkListMovies.size() == 0) {
					Toast.makeText(ListActivity.this, "Please Select...", 3000).show();
				} else if (checkListMovies.size() == 1) {
					Intent intent = new Intent(ListActivity.this,
							VideoPlayerActivity.class);
					intent.putExtra("URL", checkListMovies.get(0).url);
					ListActivity.this.startActivity(intent);
				} else {
					Intent intent = new Intent(ListActivity.this,
							FourPlayerActivity.class);
					String[] strs = new String[checkListMovies.size()];
					for (int i = 0; i < checkListMovies.size(); i++) {
						strs[i] = checkListMovies.get(i).url;
					}
					intent.putExtra("ARRAY", strs);
					ListActivity.this.startActivity(intent);
				}

			}
		});
		btnsetting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// if (setShow) {
				// setShow = false;
				// settingView.setVisibility(View.GONE);
				// } else {
				// setShow = true;
				settingView.setVisibility(View.VISIBLE);
				// }
			}
		});

		btnOk.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				settingView.setVisibility(View.GONE);
			}
		});
		btnCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				settingView.setVisibility(View.GONE);
			}
		});
	}

	private void InitView() {
		tRow1 = (TableRow) findViewById(R.id.tRow1);
		tRow2 = (TableRow) findViewById(R.id.tRow2);
		tRow3 = (TableRow) findViewById(R.id.tRow3);
		for (int i = 0; i < listMovies.size(); i++) {
			Movie movie = listMovies.get(i);
			// movie.imageUrl =
			// "http://blogfile.ifeng.com/uploadfiles/blog_attachment/1212/10/6535310_505ffa2c23f724be8dc92deaff71acfc.jpg";
			// movie.popUrl =
			// "http://blogfile.ifeng.com/uploadfiles/blog_attachment/1212/10/6535310_505ffa2c23f724be8dc92deaff71acfc.jpg";
			// movie.url = "http://www.w3schools.com/html/movie.mp4";
			// movie.id = i + 1;

			ViewGroup viewG = (ViewGroup) LayoutInflater.from(this).inflate(
					R.layout.list_item, null);
			ImageView iv = (ImageView) viewG.findViewById(R.id.iv);
			CheckBox cb = (CheckBox) viewG.findViewById(R.id.cb);

			LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			lp.leftMargin = 30;
			lp.rightMargin = 30;

			viewG.setLayoutParams(lp);
			cb.setTag(movie);
			cb.setOnCheckedChangeListener(checkLis);
			ImageLoader.getInstance().displayImage(movie.imageUrl, iv);

			if (i % 3 == 0) {
				tRow1.addView(viewG);
			} else if (i % 3 == 1) {
				tRow2.addView(viewG);
			} else if (i % 3 == 2) {
				tRow3.addView(viewG);
			}
		}
		mAdapter = new TestFragmentAdapter(getSupportFragmentManager(),
				listMovies);
		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
		CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mIndicator = indicator;
		indicator.setViewPager(mPager);
		indicator.setSnap(true);
	}

	OnCheckedChangeListener checkLis = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			Movie m = (Movie) buttonView.getTag();
			if (isChecked) {
				checkListMovies.add(m);
			} else {
				for (int i = 0; i < checkListMovies.size(); i++) {

					if (m.id == checkListMovies.get(i).id) {
						checkListMovies.remove(checkListMovies.get(i));
						break;
					}
				}
			}
		}
	};

	private void InitData() {
		listMovies = new ArrayList<ListActivity.Movie>();
		String dataStr = FileRW.readSDFile("/sdcard/huawei_movie.json");
		if (dataStr == "") {
			try {
				JSONStringer jsonText = new JSONStringer();
				jsonText.array();
				for (int i = 0; i < 9; i++) {
					jsonText.object();
					jsonText.key("id");
					jsonText.value(i);
					jsonText.key("url");
					jsonText.value("http://www.w3schools.com/html/movie.mp4");
					jsonText.key("imageUrl");
					jsonText.value("http://blogfile.ifeng.com/uploadfiles/blog_attachment/1212/10/6535310_505ffa2c23f724be8dc92deaff71acfc.jpg");
					jsonText.key("popUrl");
					jsonText.value("http://blogfile.ifeng.com/uploadfiles/blog_attachment/1212/10/6535310_505ffa2c23f724be8dc92deaff71acfc.jpg");
					jsonText.endObject();
				}
				jsonText.endArray();
				dataStr = jsonText.toString();
				FileRW.writeSDFile("/sdcard/huawei_movie.json", dataStr);

			} catch (Exception ex) {

			}
		}
		try {
			JSONArray ja = new JSONArray(dataStr);
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = (JSONObject) ja.get(i);
				Movie m = new Movie();
				m.id = jo.getInt("id");
				m.imageUrl = jo.getString("imageUrl");
				m.popUrl = jo.getString("popUrl");
				m.url = jo.getString("url");
				listMovies.add(m);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public class Movie {
		public int id;
		public String url = "";
		public String imageUrl = "";
		public String popUrl = "";
	}
}
