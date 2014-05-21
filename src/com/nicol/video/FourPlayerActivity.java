package com.nicol.video;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class FourPlayerActivity extends Activity {

	private VideoView mVideoView1;
	private VideoView mVideoView2;
	private VideoView mVideoView3;
	private VideoView mVideoView4;
	private String mPath="http://www.w3schools.com/html/movie.mp4";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fourplayer);
		mVideoView1=(VideoView)findViewById(R.id.vv1);
		mVideoView2=(VideoView)findViewById(R.id.vv2);
		mVideoView3=(VideoView)findViewById(R.id.vv3);
		mVideoView4=(VideoView)findViewById(R.id.vv4);
		
		mVideoView1.setVideoURI(Uri.parse(mPath));
		mVideoView2.setVideoURI(Uri.parse(mPath));
		mVideoView3.setVideoURI(Uri.parse(mPath));
		mVideoView4.setVideoURI(Uri.parse(mPath));
		mVideoView1.start();
		mVideoView2.start();
		mVideoView3.start();
		mVideoView4.start();
		
		OnInfoListener listener=new OnInfoListener() {
			
			@Override
			public boolean onInfo(MediaPlayer mp, int what, int extra) {
			
				switch (what) {
				case MediaPlayer.MEDIA_INFO_BUFFERING_START:
					mp.start();
					break;
				case MediaPlayer.MEDIA_INFO_BUFFERING_END:
					mp.seekTo(0);
					break;
//				case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
//					// 显示 下载速度
//					// Logger.e("download rate:" + arg2);
//					// mListener.onDownloadRateChanged(arg2);
//					break;
				}
				return true;
			}
		};
		
//		mVideoView1.setOnInfoListener(listener);
//		mVideoView2.setOnInfoListener(listener);
//		mVideoView3.setOnInfoListener(listener);
//		mVideoView4.setOnInfoListener(listener);
	}
	
}
