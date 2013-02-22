package com.collabera.labs.sai;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SimpleNotification extends Activity {
	
	private NotificationManager mNotificationManager;
	private int SIMPLE_NOTFICATION_ID;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		final Notification notifyDetails = new Notification(R.drawable.android,"New Alert, Click Me!",System.currentTimeMillis());
		

        Button start = (Button)findViewById(R.id.notifyButton);
        Button cancel = (Button)findViewById(R.id.cancelButton);
        
        start.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		
        		/*
        		 *  A PendingIntent is a token that you give to a foreign application
        		 *  (e.g. NotificationManager, AlarmManager, Home Screen AppWidgetManager,
        		 *  or other 3rd party applications), which allows the foreign application to use your
        		 *  application's permissions to execute a predefined piece of code.
        		 *
        		 */
        		
        		Context context = getApplicationContext();
        		CharSequence contentTitle = "Notification Details...";
        		CharSequence contentText = "Browse Android Official Site by clicking me";
        		
        		Intent notifyIntent = 
        				new Intent(android.content.Intent.ACTION_VIEW,
        						Uri.parse("http://www.android.com/about/")); //Implicit intent used 
        		PendingIntent intent = 
        			PendingIntent.getActivity(SimpleNotification.this, 0, 
        			notifyIntent, android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
        		
        		notifyDetails.setLatestEventInfo(context, contentTitle, contentText, intent);
        		mNotificationManager.notify(SIMPLE_NOTFICATION_ID, notifyDetails);
        	}
        });
        
        cancel.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		
        		mNotificationManager.cancel(SIMPLE_NOTFICATION_ID);
        	}
        });
    }
}