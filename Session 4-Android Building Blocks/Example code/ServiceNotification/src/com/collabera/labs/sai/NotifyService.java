package com.collabera.labs.sai;

import java.util.Calendar;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class NotifyService extends Service {

	private Long counter = 0L; 
	private NotificationManager nm;
	private Timer timer = new Timer();
	private final Calendar time = Calendar.getInstance();
	
	long timestamp;
	long timestamp1;
	long diff;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		super.onCreate();

		nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

		timestamp = System.currentTimeMillis();
		Toast.makeText(this,"Service created at " + time.getTime() + "; counter is at: " + counter, Toast.LENGTH_LONG).show();
		showNotification();		
		incrementCounter();

	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
        // Cancel the persistent notification.
		shutdownCounter();
        nm.cancel(R.string.service_started);
        timestamp1 = System.currentTimeMillis();
        diff=(timestamp1 - timestamp)/1000;
		Toast.makeText(this, "Service destroyed at " + time.getTime() + "; counter is at: " + counter,+ Toast.LENGTH_LONG).show();
		Toast.makeText(this, "Service Running for "+  diff + " Seconds ",+  Toast.LENGTH_LONG).show();
		counter=null;
	}
	
    /**
     * Show a notification while this service is running.
     */
    private void showNotification() {
        // In this sample, we'll use the same text for the ticker and the expanded notification
        CharSequence text = getText(R.string.service_started);

        // Set the icon, scrolling text and timestamp
        Notification notification = new Notification(R.drawable.android, text,
                System.currentTimeMillis());

        // The PendingIntent to launch our activity if the user selects this notification
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, ServiceLauncher.class), 0);

        // Set the info for the views that show in the notification panel.
        notification.setLatestEventInfo(this, getText(R.string.service_label),
                       text, contentIntent);

        // Send the notification.
        // We use a layout id because it is a unique number.  We use it later to cancel.
        nm.notify(R.string.service_started, notification);
    }
    
    private void incrementCounter() {
    	timer.scheduleAtFixedRate(new TimerTask(){ public void run() {counter++;}}, 0, 1000L);
    }
    
    private void shutdownCounter() {
    	if (timer != null) {
    		timer.cancel();
    	}
    }
}
