package com.example.mediaexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.view.*;

public class ImageDisplayActivity extends Activity {

	Button button;
	ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_display);
		 
	}
	
	public void moveNext(View v)
	{
		image = (ImageView) findViewById(R.id.imageView1);
		button = (Button) findViewById(R.id.btnChange);
		button.setVisibility(View.GONE);
		
		//Display next image
		image.setImageResource(R.drawable.imageandroid);

	}
 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_image_display, menu);
		return true;
	}

}
