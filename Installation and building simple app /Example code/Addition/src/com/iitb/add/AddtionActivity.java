package com.iitb.add;

import com.iitb.add.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class AddtionActivity extends Activity
 {
    /** Called when the activity is first created. */
	EditText E1,E2;
	TextView T;
	Button B1,B2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        E1=(EditText)findViewById(R.id.editText1);
        E2=(EditText)findViewById(R.id.editText2);
        B1=(Button)findViewById(R.id.button1);
        B2=(Button)findViewById(R.id.button2);
        T=(TextView)findViewById(R.id.textView4);
        B1.setOnClickListener(new Click());
        B2.setOnClickListener(new Click());
        
        }
	 class Click implements OnClickListener
	 {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 int k=Integer.parseInt(E1.getText().toString());
			 int j=Integer.parseInt(E2.getText().toString());
			 int m;
			 if(v==B1)
			 {
				 m=k+j;
			 }
			 else
			 {m=k*j;
				 
			 }
				 T.setText(m+"");
		}
		 
	 }
	 
}