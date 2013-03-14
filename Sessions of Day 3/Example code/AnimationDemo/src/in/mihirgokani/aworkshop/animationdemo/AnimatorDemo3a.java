package in.mihirgokani.aworkshop.animationdemo;

import java.util.Random;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Mihir Gokani
 * @created 02-Mar-2013 12:11:17 AM
 * 
 * Demo of {@link AnimatorSet}
 * 
 * @see {@link AnimatorDemo3b}, {@link AnimatorDemo3c}
 */
public class AnimatorDemo3a extends Activity {

    /* We want to animate by random amount (r will be used later) */
	final Random r = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animator_demo);

        /* We want to animate button1 */
		Button button1 = (Button) findViewById(R.id.button1);

		/* Animate button1.setX() over entire duration */
		ObjectAnimator a1 = ObjectAnimator.ofFloat(button1, "x", r.nextInt(200));
		a1.setDuration(1000);

		/* Animate button1.setY() over entire duration */
		ObjectAnimator a2 = ObjectAnimator.ofFloat(button1, "y", r.nextInt(200));
		a2.setDuration(1000);

		/* Play a1 and a2 together */
		final AnimatorSet a = new AnimatorSet();
		a.playTogether(a1, a2); // Or, "a.playSequencially(a1, a2)" to play a1 and a2 one after the other

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				a.start();
			}
		});
	}
}
