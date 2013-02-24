package com.example.mediaexample;



import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;

public class MediaExample extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media_example);	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_media_example, menu);
		return true;
	}
	
	public void DisplayVideo(View v)
	{//Call VideoDisplay activity to play video
		 Intent myIntent = new Intent(MediaExample.this, VideoDisplayActivity.class);			
         startActivity(myIntent);
	}	
	
	public void DisplayImages(View v)
	{//call ImageDisplay activity to show ImageView

	    Intent myIntent = new Intent(MediaExample.this, ImageDisplayActivity.class);			
        startActivity(myIntent);
	}
	
}
	

