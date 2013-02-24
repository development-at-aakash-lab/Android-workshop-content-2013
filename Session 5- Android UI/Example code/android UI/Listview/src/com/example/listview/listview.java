package com.example.listview;


import java.util.ArrayList;



import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.support.v4.app.NavUtils;

public class listview extends Activity {
	    ArrayList <String> Fruits=new ArrayList();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
       listDisplay(); 
       
        
           }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_listview, menu);
        return true;
    }

    public void listDisplay()
	{
    	Fruits.add("Apple");
		Fruits.add("Mango");
		Fruits.add("Grapes");
		Fruits.add("Strawberry");
		Fruits.add("Watermelon");
		
		   ListView lv = (ListView) findViewById(R.id.listView1); 
		   if(!Fruits.isEmpty())
		   {
			   ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Fruits);
			   
	            lv.setAdapter(arrayAdapter);
		   }
	}
}
