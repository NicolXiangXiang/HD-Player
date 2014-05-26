package com.nicol.video;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.VideoView;

public class FourPlayerActivity extends Activity {

	private VideoView mVideoView1;
	private VideoView mVideoView2;
	private VideoView mVideoView3;
	private VideoView mVideoView4;

	private View vl1;
	private View vl2;
	private View vl3;
	private View vl4;

	private MediaPlayer mp1;
	private MediaPlayer mp2;
	private MediaPlayer mp3;
	private MediaPlayer mp4;

	private RadioGroup rg;
	private RadioButton rb1;
	private RadioButton rb2;
	private RadioButton rb3;
	private RadioButton rb4;

	private String mPath = "http://www.w3schools.com/html/movie.mp4";

	OnPreparedListener onprepared1 = new OnPreparedListener() {
		@Override
		public void onPrepared(MediaPlayer arg0) {
			mp1 = arg0;
			rb1.setEnabled(true);
			vl1.setVisibility(View.GONE);
			int iii=rg.getCheckedRadioButtonId();
			if (iii ==-1) {
				rb1.setChecked(true);
			} else {
				arg0.setVolume(0, 0);
			}
		}
	};
	OnPreparedListener onprepared2 = new OnPreparedListener() {
		@Override
		public void onPrepared(MediaPlayer arg0) {
			mp2 = arg0;
			rb2.setEnabled(true);
			vl2.setVisibility(View.GONE);
			arg0.setVolume(0, 0);
		}
	};
	OnPreparedListener onprepared3 = new OnPreparedListener() {
		@Override
		public void onPrepared(MediaPlayer arg0) {
			mp3 = arg0;
			rb3.setEnabled(true);
			vl3.setVisibility(View.GONE);
			arg0.setVolume(0, 0);
		}
	};
	OnPreparedListener onprepared4 = new OnPreparedListener() {
		@Override
		public void onPrepared(MediaPlayer arg0) {
			mp4 = arg0;
			rb4.setEnabled(true);
			vl4.setVisibility(View.GONE);
			arg0.setVolume(0, 0);
		}
	};

	private void setMute() {
		if (mp1 != null)
			mp1.setVolume(0, 0);
		if (mp2 != null)
			mp2.setVolume(0, 0);
		if (mp3 != null)
			mp3.setVolume(0, 0);
		if (mp4 != null)
			mp4.setVolume(0, 0);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = this.getIntent();

		String[] strs = intent.getStringArrayExtra("ARRAY");

		setContentView(R.layout.activity_fourplayer);
		mVideoView1 = (VideoView) findViewById(R.id.vv1);
		mVideoView2 = (VideoView) findViewById(R.id.vv2);
		mVideoView3 = (VideoView) findViewById(R.id.vv3);
		mVideoView4 = (VideoView) findViewById(R.id.vv4);

		vl1 = findViewById(R.id.vl1);
		vl2 = findViewById(R.id.vl2);
		vl3 = findViewById(R.id.vl3);
		vl4 = findViewById(R.id.vl4);

		rg = (RadioGroup) findViewById(R.id.rg);
		rb1 = (RadioButton) findViewById(R.id.rb1);
		rb2 = (RadioButton) findViewById(R.id.rb2);
		rb3 = (RadioButton) findViewById(R.id.rb3);
		rb4 = (RadioButton) findViewById(R.id.rb4);

		rb1.setEnabled(false);
		rb2.setEnabled(false);
		rb3.setEnabled(false);
		rb4.setEnabled(false);

		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				setMute();
				if (arg1 == rb1.getId()) {
					mp1.setVolume(1, 1);
				} else if (arg1 == rb2.getId()) {
					mp2.setVolume(1, 1);
				} else if (arg1 == rb3.getId()) {
					mp3.setVolume(1, 1);
				} else if (arg1 == rb4.getId()) {
					mp4.setVolume(1, 1);
				}
			}
		});

		mVideoView1.setVideoURI(Uri.parse(strs[0]));
		mVideoView1.start();
		vl1.setVisibility(View.VISIBLE);
		mVideoView1.setOnPreparedListener(onprepared1);
		mVideoView1.setOnInfoListener(new OnInfoListener() {
			@Override
			public boolean onInfo(MediaPlayer arg0, int arg1, int arg2) {
				switch (arg1) {
				case MediaPlayer.MEDIA_INFO_BUFFERING_START:
					vl1.setVisibility(View.VISIBLE);
					break;
				case MediaPlayer.MEDIA_INFO_BUFFERING_END:
					vl1.setVisibility(View.GONE);
					break;
				}
				return true;
			}
		});

		if (strs.length > 1) {
			mVideoView2.setVideoURI(Uri.parse(strs[1]));
			mVideoView2.start();
			vl2.setVisibility(View.VISIBLE);
			mVideoView2.setOnPreparedListener(onprepared2);
			mVideoView2.setOnInfoListener(new OnInfoListener() {
				@Override
				public boolean onInfo(MediaPlayer arg0, int arg1, int arg2) {
					switch (arg1) {
					case MediaPlayer.MEDIA_INFO_BUFFERING_START:
						vl2.setVisibility(View.VISIBLE);
						break;
					case MediaPlayer.MEDIA_INFO_BUFFERING_END:
						vl2.setVisibility(View.GONE);
						break;
					}
					return true;
				}
			});
		} else {
			rb2.setEnabled(false);
		}

		if (strs.length > 2) {
			mVideoView3.setVideoURI(Uri.parse(strs[2]));
			mVideoView3.start();
			vl3.setVisibility(View.VISIBLE);
			mVideoView3.setOnPreparedListener(onprepared3);
			mVideoView3.setOnInfoListener(new OnInfoListener() {
				@Override
				public boolean onInfo(MediaPlayer arg0, int arg1, int arg2) {
					switch (arg1) {
					case MediaPlayer.MEDIA_INFO_BUFFERING_START:
						vl3.setVisibility(View.VISIBLE);
						break;
					case MediaPlayer.MEDIA_INFO_BUFFERING_END:
						vl3.setVisibility(View.GONE);
						break;
					}
					return true;
				}
			});
		} else {
			rb3.setEnabled(false);
		}

		if (strs.length > 3) {
			mVideoView4.setVideoURI(Uri.parse(strs[3]));
			mVideoView4.start();
			vl4.setVisibility(View.VISIBLE);
			mVideoView4.setOnPreparedListener(onprepared4);
			mVideoView4.setOnInfoListener(new OnInfoListener() {
				@Override
				public boolean onInfo(MediaPlayer arg0, int arg1, int arg2) {
					switch (arg1) {
					case MediaPlayer.MEDIA_INFO_BUFFERING_START:
						vl4.setVisibility(View.VISIBLE);
						break;
					case MediaPlayer.MEDIA_INFO_BUFFERING_END:
						vl4.setVisibility(View.GONE);
						break;
					}
					return true;
				}
			});
		} else {
			rb4.setEnabled(false);
		}

		OnInfoListener listener = new OnInfoListener() {

			@Override
			public boolean onInfo(MediaPlayer mp, int what, int extra) {

				switch (what) {
				case MediaPlayer.MEDIA_INFO_BUFFERING_START:
					mp.start();
					break;
				case MediaPlayer.MEDIA_INFO_BUFFERING_END:
					mp.seekTo(0);
					break;
				// case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
				// // 显示 下载速度
				// // Logger.e("download rate:" + arg2);
				// // mListener.onDownloadRateChanged(arg2);
				// break;
				}
				return true;
			}
		};

		// mVideoView1.setOnInfoListener(listener);
		// mVideoView2.setOnInfoListener(listener);
		// mVideoView3.setOnInfoListener(listener);
		// mVideoView4.setOnInfoListener(listener);
	}

}
