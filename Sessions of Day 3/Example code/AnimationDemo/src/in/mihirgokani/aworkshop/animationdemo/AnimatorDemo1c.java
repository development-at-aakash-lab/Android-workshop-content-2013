package in.mihirgokani.aworkshop.animationdemo;

import android.animation.Animator;
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
import android.view.animation.BounceInterpolator;

/**
 * @author Mihir Gokani
 * @created 01-Mar-2013 12:45:11 PM
 * 
 * Using {@link Animator} in conjunction with {@link Canvas}.
 */
public class AnimatorDemo1c extends Activity {

	final Paint paint;

	ShapeDrawable myShapeDrawable;
	MyObject o;

	/**
	 * Constructor for AnimatorDemo1a
	 */
	public AnimatorDemo1c() {

		/* Setup paint */
		paint = new Paint();
		paint.setColor(Color.argb(100, 50, 100, 200));
		paint.setTextSize(32f);
		
		o = new MyObject();
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

		/* Setup Animator (NOTE: We are actually object of our custom class!) */
		ObjectAnimator a = ObjectAnimator.ofFloat(o, "prop", -250, 250);
		a.setDuration(10000);
		a.setInterpolator(new BounceInterpolator());

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
			canvas.save();
			canvas.translate(0f, o.getProp());
			myShapeDrawable.draw(canvas);
			canvas.restore(); // LINE A
			
			/* Try commenting LINE A and uncommenting LINE B */
			canvas.translate(50f, 0f);
			myShapeDrawable.draw(canvas);
			//canvas.restore(); // LINE B
		}
	}

}
