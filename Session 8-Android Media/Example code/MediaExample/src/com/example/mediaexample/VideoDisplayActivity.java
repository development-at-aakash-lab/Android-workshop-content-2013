package com.example.mediaexample;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoDisplayActivity extends Activity {
	private MediaController ctlr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_display);
		
		//Get the reference
		VideoView view = (VideoView)findViewById(R.id.videoDisplay);
		String path = "/mnt/sdcard/vodafone.3gp";
		
		/*You can set path in different ways:
		 * view.setVideoURI(Uri.parse(path));
		 * view.setVideoPath(Environment.getExternalStorageDirectory()+"filename.extension");
		 * view.setVideoPath("/mnt/sdcard/filename.extension);
		*/
	
		//MediaController adds control buttons to video view
		view.setMediaController(new MediaController(this));	
		
		view.setVideoPath(path);
		
		view.start();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_video_display, menu);
		return true;
	}

}
