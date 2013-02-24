package com.example.videocapturedemo;



import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoCaptureDemo extends Activity {
	 private static final int ACTION_TAKE_VIDEO = 1888; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_capture_demo);
	}
	
	public void DispatchVideoIntent(View v)
	{
		   Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		   startActivityForResult(takeVideoIntent, ACTION_TAKE_VIDEO);

	

	}

protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        if (requestCode == ACTION_TAKE_VIDEO && resultCode == RESULT_OK) {  
        	
	     	  Uri mVideoUri = data.getData();
	     	//  mVideoUri  = data.getData();
	     	  
            Toast.makeText(VideoCaptureDemo.this, mVideoUri .getPath(),
                    Toast.LENGTH_LONG).show();
	     	    
	        }  
	    } 

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_video_capture_demo, menu);
		return true;
	}

}
