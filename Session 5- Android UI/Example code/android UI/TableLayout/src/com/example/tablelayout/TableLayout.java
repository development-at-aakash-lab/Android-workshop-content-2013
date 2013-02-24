package com.example.tablelayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
//import android.view.MenuItem;
import android.widget.*;
//import android.support.v4.app.NavUtils;
import android.view.View;
//import android.view.View.OnClickListener;

public class TableLayout extends Activity {

	Button button1, button2;
	TextView tv1,tv3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        
    
    
      
      
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_table_layout, menu);
        return true;
    }

    
}
