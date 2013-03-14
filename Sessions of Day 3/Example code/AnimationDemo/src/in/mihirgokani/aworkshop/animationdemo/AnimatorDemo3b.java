package in.mihirgokani.aworkshop.animationdemo;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;

/**
 * @author Mihir Gokani
 * @created 02-Mar-2013 12:11:17 AM
 * 
 * Demo of {@link ViewPropertyAnimator}
 * 
 * @see {@link AnimatorDemo3a}, {@link AnimatorDemo3c}
 */
public class AnimatorDemo3b extends Activity {

    /* We want to animate by random amount (r will be used later) */
    final Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_demo);

        /* We want to animate button1 */
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	/* Method chaining */
                view.animate() // Returns ViewPropertyAnimator object
                		.setDuration(1000) // Also returns ViewPropertyAnimator object
                		.xBy(r.nextInt(200)) // Also returns ViewPropertyAnimator object
                        .yBy(r.nextInt(200));  // Also returns ViewPropertyAnimator object
            }
        });
    }
}
