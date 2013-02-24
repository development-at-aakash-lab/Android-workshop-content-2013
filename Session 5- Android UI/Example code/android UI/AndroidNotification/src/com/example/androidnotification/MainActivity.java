package com.example.androidnotification;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final int MY_NOTIFICATION_ID=1;
	private NotificationManager notificationManager;
	private Notification myNotification;

	private final String notificate = "http://www.iitb.ac.in/";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button buttonSend = (Button)findViewById(R.id.send);
		buttonSend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				notificationManager =
					    (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
					   myNotification = new Notification(R.drawable.ic_launcher,
					     "Notification!",
					     System.currentTimeMillis());
					   Context context = getApplicationContext();
					   String notificationTitle = "Exercise of Notification!";
					   String notificationText = "www.iitb.ac.in/";
					   Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(notificate));
					   PendingIntent pendingIntent
					     = PendingIntent.getActivity(MainActivity.this,
					       0, myIntent,
					       Intent.FLAG_ACTIVITY_NEW_TASK);
					   myNotification.defaults |= Notification.DEFAULT_SOUND;
					   myNotification.flags |= Notification.FLAG_AUTO_CANCEL;
					   myNotification.setLatestEventInfo(context,
					      notificationTitle,
					      notificationText,
					      pendingIntent);
					   notificationManager.notify(MY_NOTIFICATION_ID, myNotification);
				
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
