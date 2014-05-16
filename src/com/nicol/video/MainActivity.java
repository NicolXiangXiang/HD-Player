package com.nicol.video;

import java.util.Timer;
import java.util.TimerTask;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Intent intent = new Intent(MainActivity.this,
						ListActivity.class);
				MainActivity.this.startActivity(intent);
				MainActivity.this.finish();
			}
		}, 3000);

		// VideoView vd1=(VideoView) findViewById(R.id.videoView1);
		// VideoView vd2=(VideoView) findViewById(R.id.videoView2);
		// vd1.setVideoURI(Uri.parse("http://www.w3schools.com/html/movie.mp4"));
		// vd1.setMediaController(new MediaController(this));
		// vd1.requestFocus();
		// vd1.start();
		//
		// vd2.setVideoURI(Uri.parse("http://www.w3schools.com/html/movie.mp4"));
		// vd2.setMediaController(new MediaController(this));
		// vd2.requestFocus();
		// vd2.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
