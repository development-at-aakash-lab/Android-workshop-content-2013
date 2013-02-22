package com.example.activityexample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Screen2 extends Activity {
	String title;
	TextView msg;
	Button button1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        msg = (TextView) findViewById(R.id.textView2);
    	button1 = (Button) findViewById(R.id.button1);
        msg.setTextColor(Color.RED);
        
        
        title = getIntent().getExtras().getString("text2");
        msg.setText("  "+ title);
       
        button1.setOnClickListener(new OnClickListener() {
       	 
			public void onClick(View arg0) {
                                         
			    Intent intent = new Intent(Screen2.this,MainActivity.class);//Explicit Intent used here.
			   startActivity(intent);  // Opening new Activity
 
			}
 
		});
 
        
        
    }

   
}
