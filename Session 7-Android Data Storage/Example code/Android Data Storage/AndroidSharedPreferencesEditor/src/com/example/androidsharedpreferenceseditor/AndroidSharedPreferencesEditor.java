package com.example.androidsharedpreferenceseditor;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AndroidSharedPreferencesEditor extends Activity {
	
	EditText editText1, editText2;
	TextView textSavedMem1, textSavedMem2;
	Button buttonSaveMem1, buttonSaveMem2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textSavedMem1 = (TextView)findViewById(R.id.savedmem1);
        textSavedMem2 = (TextView)findViewById(R.id.savedmem2);
        editText1 = (EditText)findViewById(R.id.edittext1);
        editText2 = (EditText)findViewById(R.id.edittext2);
        buttonSaveMem1 = (Button)findViewById(R.id.save_mem1);
        buttonSaveMem2 = (Button)findViewById(R.id.save_mem2);
        
        buttonSaveMem1.setOnClickListener(buttonSaveMem1OnClickListener);
        buttonSaveMem2.setOnClickListener(buttonSaveMem2OnClickListener);
        
        LoadPreferences();
    }
    
    Button.OnClickListener buttonSaveMem1OnClickListener
    	= new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SavePreferences("MEM1", editText1.getText().toString());
				LoadPreferences();
			}
    	
    };
    
    Button.OnClickListener buttonSaveMem2OnClickListener
		= new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SavePreferences("MEM2", editText2.getText().toString());
				LoadPreferences();
			}
	
    };
    
    private void SavePreferences(String key, String value){
    	SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
    	SharedPreferences.Editor editor = sharedPreferences.edit();
    	editor.putString(key, value);
    	editor.commit();
    }
    
    private void LoadPreferences(){
    	SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
    	String strSavedMem1 = sharedPreferences.getString("MEM1", "");
    	String strSavedMem2 = sharedPreferences.getString("MEM2", "");
    	textSavedMem1.setText(strSavedMem1);
    	textSavedMem2.setText(strSavedMem2);
    }
}