package in.mihirgokani.aworkshop.animationdemo;

import android.animation.ObjectAnimator;
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
 * Demo of {@link ObjectAnimator}
 * 
 * @see AnimatorDemo1a
 */
public class AnimatorDemo1b extends Activity {

	final Paint paint;

	ShapeDrawable myShapeDrawable;

	/**
	 * Constructor for AnimatorDemo1a
	 */
	public AnimatorDemo1b() {

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

    	/* Setup Animator */
		ObjectAnimator a = ObjectAnimator.ofInt(myShapeDrawable, "alpha", 0, 100);
		a.setDuration(10000);

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
