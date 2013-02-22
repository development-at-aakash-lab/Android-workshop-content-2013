package com.collabera.labs.sai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceLauncher extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicelauncher);
        
        
        Button start = (Button)findViewById(R.id.startButton);
        Button stop = (Button)findViewById(R.id.stopButton);
        
        start.setOnClickListener(startListener);
        stop.setOnClickListener(stopListener);
       
    }
    
    private OnClickListener startListener = new OnClickListener() {
       	public void onClick(View v){
       		startService(new Intent(ServiceLauncher.this,NotifyService.class));//Explicit intent used.
       	}	        	
       };
       
    private OnClickListener stopListener = new OnClickListener() {
      	public void onClick(View v){
      		stopService(new Intent(ServiceLauncher.this,NotifyService.class));
      	}	        	
      };
}