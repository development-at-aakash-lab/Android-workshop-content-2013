package com.example.imagecapturedemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.ImageView;

public class ImageCaptureDemo extends Activity {
	 private static final int CAMERA_REQUEST = 1888; 
	 private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_capture_demo);
		
		//Get reference of button and imageview
		 this.imageView = (ImageView)this.findViewById(R.id.imageView1);
		 Button photoButton = (Button) this.findViewById(R.id.button1);
	        
	        photoButton.setOnClickListener(new OnClickListener(){

	            @Override
	            public void onClick(View v) {
	            	//Create instance of intent for camera
	                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
	                
	                /*call activity camera using intent created above....
	                As we need picture from camera activity we call startActivityForResult instead of startActivity
	                */
	                startActivityForResult(cameraIntent, CAMERA_REQUEST); 
	            }
	        });
	    }

		/*onActivityResult(int requestCode, int resultCode, Intent data)
		 * requestcode: determines type of activity 
		 * resultcode: determines called activity was successful or not
		 * data: returns data back from called activity
		 */
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
	            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
	            imageView.setImageBitmap(photo);
	        }  
	    } 


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_image_capture_demo, menu);
		return true;
	}

}
