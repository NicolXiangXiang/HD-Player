package com.nicol.video;

import com.nicol.video.ListActivity.Movie;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class TestFragment extends Fragment {
	private static final String KEY_URL = "TestFragment:url";
	private static final String KEY_POPURL = "TestFragment:popUrl";

	public static TestFragment newInstance(String _url, String _popUrl) {
		TestFragment fragment = new TestFragment();
		fragment.url = _url;
		fragment.popUrl = _popUrl;
		return fragment;
	}

	private String url = "";
	private String popUrl = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if ((savedInstanceState != null)
				&& savedInstanceState.containsKey(KEY_URL)) {
			url = savedInstanceState.getString(KEY_URL);
		}
		if ((savedInstanceState != null)
				&& savedInstanceState.containsKey(KEY_POPURL)) {
			popUrl = savedInstanceState.getString(KEY_POPURL);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup layout = (ViewGroup) inflater.cloneInContext(getActivity())
				.inflate(R.layout.pop, null);
		ImageView iv = (ImageView) layout.findViewById(R.id.iv);
		ImageLoader.getInstance().displayImage(popUrl, iv);

		ImageView ivBtn = (ImageView) layout.findViewById(R.id.iv_btn);
		ivBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(),
						VideoPlayerActivity.class);
				intent.putExtra("URL", url);
				getActivity().startActivity(intent);
			}
		});
		return layout;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(KEY_URL, url);
		outState.putString(KEY_POPURL, popUrl);
	}
}
