package com.example.activityexample;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button button;
	EditText text1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton() {
   	 
		
    	 
    	button = (Button) findViewById(R.id.button1);
		text1 = (EditText) findViewById(R.id.editText1);
	
    			
    			button.setOnClickListener(new OnClickListener() {
    	 
    				public void onClick(View arg0) {
    	                                         
    				    Intent intent = new Intent(MainActivity.this,Screen2.class);//Explicit Intent used here.
    				    intent.putExtra("text2",text1.getText().toString());//Sending values to new Activity
     				    startActivity(intent);  // Opening new Activity
    	 
    				}
    	 
    			});
    	 
    		}

   
}
