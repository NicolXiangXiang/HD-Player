package com.nicol.video;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

@SuppressLint("SetJavaScriptEnabled")
public class OnePlayerActivity extends Activity {

	WebView wv;
	VideoView vv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oneplayer);
		
		vv=(VideoView)findViewById(R.id.vv1);
		MediaController mController = new MediaController(this);  
        vv.setMediaController(mController);//����һ��������  
		
		Uri uri = Uri.parse("http://www.w3schools.com/html/movie.mp4");  
        //Uri uri = Uri.parse("http://daily3gp.com/vids/family_guy_penis_car.3gp");  
        vv.setVideoURI(uri); 
        vv.requestFocus(); 
        vv.start(); 
		
//		wv = (WebView) findViewById(R.id.wv);
//
//		// String html="<video  controls autoplay=\"autoplay\" id=\"video\">"+
//		// "<source src=\"http://www.w3schools.com/html/movie.mp4\" type=\"video/mp4\">"+
//		// "<source src=\"http://www.w3schools.com/html/movie.oog\" type=\"video/ogg\">"+
//		// "Your browser does not support the video tag."+
//		// "</video>=====================<script type=\"text/javascript\"> alert('123');var video = document.getElementById('video');video.play();</script>";
//		//
//		// // ����WevViewҪ��ʾ����ҳ
//		// wv.loadDataWithBaseURL(null, html, "text/html", "utf-8",
//		// null);
//
//		wv.getSettings().setJavaScriptEnabled(true); // ����֧��Javascript
//		wv.getSettings().setJavaScriptEnabled(true);
//		wv.getSettings().setAllowFileAccess(true);
//		// wv.getSettings().setPluginsEnabled(true);
//		wv.getSettings().setAllowFileAccess(true);
//
//		wv.setWebViewClient(new WebViewClient() {
//			@Override
//			public void onPageFinished(WebView view, String url) {
//				view.loadUrl("javascript:play()");
//			}
//		});
//
//		wv.setWebChromeClient(new WebChromeClient());
//		//wv.loadUrl("http://www.w3schools.com/html/tryit.asp?filename=tryhtml5_video_all");
//		wv.loadUrl("file:///android_asset/player.html");

	}
}
