package com.example.notificationdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class Notify extends Activity {

		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        
        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
					@SuppressWarnings("deprecation")
					Notification notify=new Notification(android.R.drawable.stat_notify_more, "Notification", 
							System.currentTimeMillis());
					Context context=Notify.this;
					CharSequence title="You have been notified";
					CharSequence details="Continue with what you are doing";
					Intent intent=new Intent(context, Notify.class);
					PendingIntent pending=PendingIntent.getActivity(context,0,intent,0);
					notify.setLatestEventInfo(context, title, details, pending);
					nm.notify(0,notify);
			}
		});
        
        
       

			}
		
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_notify, menu);
        return true;
    }

    
}
