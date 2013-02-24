package com.example.form;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.text.format.DateFormat;
import android.widget.*;

public class Form extends Activity implements AdapterView.OnItemSelectedListener{
	

	Spinner spin;			//declaring UI control objects
	Button reset;
	Button submit;
	CheckBox ch1,ch2,ch3,ch4;
	RadioButton radio1;

	String[] items = { "Algeria", "Brazil", "Denmark","France", "India",   //Declaring and defining string array 
			"Japan","Kenya","Malaysia","New Zealand","Oman",			   
			"Poland", "Russia","South Africa","Thailand","United States" };
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        
       final EditText fname = (EditText) findViewById(R.id.editText1);       //Defining UI control objects         
       final EditText lname = (EditText) findViewById(R.id.editText2);  
      
       reset=(Button)findViewById(R.id.button1);
       submit=(Button)findViewById(R.id.button2);
       
       spin = (Spinner) findViewById(R.id.spinner1);
       
      
		
		spin.setOnItemSelectedListener(this);			

		ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,items);
		aa.setDropDownViewResource(									//to pull the contents of string array
		android.R.layout.simple_spinner_dropdown_item);				// in spinner
		spin.setAdapter(aa); 	     
                         
    
		reset.setOnClickListener(new View.OnClickListener() {
																//event handling on reset button
		@Override												//form elements get reset
		public void onClick(View v) {
			// TODO Auto-generated method stub
			((EditText)findViewById(R.id.editText1)).setText("");
			((EditText)findViewById(R.id.editText2)).setText("");
			radio1 = (RadioButton)findViewById(R.id.radioMale);
			radio1.setChecked(true);
		    spin = (Spinner)findViewById(R.id.spinner1);
		    spin.setSelection(0);
		    ch1 = (CheckBox)findViewById(R.id.checkBox1);
		    ch2 = (CheckBox)findViewById(R.id.checkBox2);
		    ch3 = (CheckBox)findViewById(R.id.checkBox3);
		    ch4 = (CheckBox)findViewById(R.id.checkBox4);
		    ch1.setChecked(false);
		    ch2.setChecked(false);
		    ch3.setChecked(false);
		    ch4.setChecked(false);

				}
       		});
 
		submit.setOnClickListener(new View.OnClickListener() {
																	//event handling on submit button
		@Override													//data filled in form will be			
		public void onClick(View arg0) {							//sent to database
			// TODO Auto-generated method stub
			((EditText)findViewById(R.id.editText1)).setText("");
			((EditText)findViewById(R.id.editText2)).setText("");
			radio1 = (RadioButton)findViewById(R.id.radioMale);
			radio1.setChecked(true);
		    spin = (Spinner)findViewById(R.id.spinner1);
		    spin.setSelection(0);
		    ch1 = (CheckBox)findViewById(R.id.checkBox1);
		    ch2 = (CheckBox)findViewById(R.id.checkBox2);
		    ch3 = (CheckBox)findViewById(R.id.checkBox3);
		    ch4 = (CheckBox)findViewById(R.id.checkBox4);
		    ch1.setChecked(false);
		    ch2.setChecked(false);
		    ch3.setChecked(false);
		    ch4.setChecked(false);
			}
 			});
 
}
		public void onNothingSelected(AdapterView<?> parent) {
			
		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form, menu);
        return true;
		}

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
		
		}
  
}
