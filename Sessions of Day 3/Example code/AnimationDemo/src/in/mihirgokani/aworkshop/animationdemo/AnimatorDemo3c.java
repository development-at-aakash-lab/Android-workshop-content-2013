package in.mihirgokani.aworkshop.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Mihir Gokani
 * @created 02-Mar-2013 12:31:08 AM
 * 
 * Demo of defining animators in XML file.
 * 
 * @see res/animator/animator_demo.xml
 * @see res/layout/activity_animator_demo.xml
 * @see {@link AnimatorDemo3a}, {@link AnimatorDemo3b}
 */
public class AnimatorDemo3c extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_demo);

        /* We want to animate button1 */
        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	/* Load animator from XML */
                Animator a = (AnimatorSet) AnimatorInflater.loadAnimator(
                        AnimatorDemo3c.this, R.animator.animator_demo);
            	/* view IS the button1 which we want to animate */
                a.setTarget(view);
                a.start();
            }
        });
    }
}
