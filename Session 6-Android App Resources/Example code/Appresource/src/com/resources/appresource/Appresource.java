package com.resources.appresource;



import com.resources.appresources.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class Appresource extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appresources);
       TextView txt1=(TextView)findViewById(R.id.textView1); 
       TextView txt2=(TextView)findViewById(R.id.textView2);
       String str=getResources().getString(R.string.stringresources);
       txt1.setText(str);
       
        int colour=getResources().getColor(R.color.Yellow);              /*USE OF COLOR RESOURCES*/
        View sv=findViewById(R.id.rel);
        sv.setBackgroundColor(colour);
        
        float dimension=getResources().getDimension(R.dimen.medium_size);/*USE OF DIMENSION RESOURCES*/
        txt1.setTextSize(dimension);
        
        txt2.setTextAppearance(getApplicationContext(),R.style.styleresource);/*USE OF STYLE RESOURCES*/
        
        Button bt1=(Button)findViewById(R.id.button1);
        Drawable image1=getResources().getDrawable(R.drawable.d2);           /*USE OF DRAWABLE RESOURCES*/
        
        bt1.setBackgroundDrawable(image1);
 
    
        ColorDrawable colordraw=(ColorDrawable)this.getResources().getDrawable(R.drawable.rectangle_green); /*USE OF COLOR-DRAWABLE RESOURCES*/
        txt1.setBackgroundDrawable(colordraw);
        
        Animation viewanim=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);  /* using view animation*/
        bt1.startAnimation(viewanim); 
         
         ImageView imgv=(ImageView)findViewById(R.id.imageView1);       
    
       
          imgv.setBackgroundResource(R.anim.frameanim);       /*using frame animation on click button*/
          final AnimationDrawable rckanim=(AnimationDrawable)imgv.getBackground();
          bt1.setOnClickListener(new View.OnClickListener() {   
               public void onClick(View v) {
                    // TODO Auto-generated method stub
                    rckanim.start();
               }
         });
         
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appresources, menu);
		getMenuInflater().inflate(R.menu.menus,menu);        /*USE OF MENU RESOURCES*/
	
		return true;
	}

}
