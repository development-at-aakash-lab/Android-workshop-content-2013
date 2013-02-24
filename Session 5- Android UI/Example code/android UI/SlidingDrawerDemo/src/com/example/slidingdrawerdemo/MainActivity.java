package com.example.slidingdrawerdemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button slideButton,b1, b2,b3,b4;
    SlidingDrawer slidingDrawer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
			
		
		slideButton = (Button) findViewById(R.id.handle);
        slidingDrawer = (SlidingDrawer) findViewById(R.id.slidingDrawer1);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
 
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
	
        slidingDrawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                slideButton.setBackgroundResource(R.drawable.ic_launcher);
            }
        });
 
        slidingDrawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                slideButton.setBackgroundResource(R.drawable.ic_launcher);
            }
        }); 
	}

	@Override
		public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Button b = (Button)v;
        Toast.makeText(MainActivity.this, b.getText() + " Clicked", Toast.LENGTH_SHORT).show();
		
	}

}
