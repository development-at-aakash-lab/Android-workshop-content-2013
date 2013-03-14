package in.mihirgokani.aworkshop.animationdemo;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.View;

/**
 * @author Mihir Gokani
 * @created 01-Mar-2013 12:45:11 PM
 * 
 * Demo of {@link Keyframe}s
 */
public class AnimatorDemo2 extends Activity {

	final Paint paint;

	ShapeDrawable myShapeDrawable;

	/**
	 * Constructor for AnimatorDemo1a
	 */
	public AnimatorDemo2() {

		/* Setup paint */
		paint = new Paint();
		paint.setColor(Color.argb(100, 50, 100, 200));
		paint.setTextSize(32f);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Shape shape;

    	/* Setup shape */
        shape = new OvalShape();
        shape.resize(50, 50);

    	/* Setup drawable */
		myShapeDrawable = new ShapeDrawable(shape);
		myShapeDrawable.getPaint().set(paint);
		myShapeDrawable.setBounds(125, 225, 275, 375);

    	/* Setup view (which will draw our drawable) */
		final MyView myView = new MyView(this);
		setContentView(myView);

    	/* Setup Keyframes (Colors are actually integers!) */
		Keyframe kf1 = Keyframe.ofInt(0f, Color.BLACK);		// 0f#----------------1f
		Keyframe kf2 = Keyframe.ofInt(0.25f, Color.GREEN);	// 0f----#------------1f
		Keyframe kf3 = Keyframe.ofInt(0.5f, Color.WHITE);	// 0f--------#--------1f
		Keyframe kf4 = Keyframe.ofInt(0.75f, Color.RED);	// 0f------------#----1f
		Keyframe kf5 = Keyframe.ofInt(1f, Color.YELLOW);	// 0f----------------#1f

		/* Setup Animator (NOTE: We are actually animating the paint of our drawable!) */
		ObjectAnimator a = ObjectAnimator.ofPropertyValuesHolder(myShapeDrawable.getPaint(), 
				PropertyValuesHolder.ofKeyframe("color", kf1, kf2, kf3, kf4, kf5));
		a.setDuration(10000);
		
		/* Although Colors are integers, we need to specify evaluator to 
		 * get a smooth change of colors. Try commenting this out! */
		a.setEvaluator(new ArgbEvaluator());

		a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        	/* Listen to the update event */
			@Override
			public void onAnimationUpdate(ValueAnimator va) {
				myView.invalidate(); // Redraw!
			}
		});

		a.start();
	}

	/* Our custom view which will draw the drawable */
	private class MyView extends View {

		public MyView(Context context) {
			super(context);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			myShapeDrawable.draw(canvas);
		}
	}

}
