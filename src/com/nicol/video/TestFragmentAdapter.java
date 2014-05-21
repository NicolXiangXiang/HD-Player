package com.nicol.video;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nicol.video.ListActivity.Movie;
import com.viewpagerindicator.IconPagerAdapter;

class TestFragmentAdapter extends FragmentPagerAdapter implements
		IconPagerAdapter {
	protected List<Movie> Movies;
	protected static final int[] ICONS = new int[] {
			R.drawable.perm_group_calendar, R.drawable.perm_group_camera,
			R.drawable.perm_group_device_alarms, R.drawable.perm_group_location };

	private int mCount;

	public TestFragmentAdapter(FragmentManager fm, List<Movie> movies) {
		super(fm);
		Movies = movies;
		mCount = Movies.size();
	}

	@Override
	public Fragment getItem(int position) {
		return TestFragment.newInstance(Movies.get(position % mCount).url,
				Movies.get(position % mCount).popUrl);
	}

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "";
	}

	@Override
	public int getIconResId(int index) {
		return ICONS[index % ICONS.length];
	}

	public void setCount(int count) {
		if (count > 0 && count <= 10) {
			mCount = count;
			notifyDataSetChanged();
		}
	}
}