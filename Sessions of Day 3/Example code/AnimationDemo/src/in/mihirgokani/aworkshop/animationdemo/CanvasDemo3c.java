package in.mihirgokani.aworkshop.animationdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Mihir Gokani
 * @created 02-Mar-2013 11:12:21 AM
 * 
 * Drawing many {@link Drawable}s at once (stored in {@link ArrayList}).
 * Also add new {@link Drawable} to this list on touch event.
 */
public class CanvasDemo3c extends Activity {

    final Paint paint;
    final ArrayList<ShapeDrawable> drawables;

    final Shape touchShape;

    /**
     * Constructor for CanvasDemo3b
     */
    public CanvasDemo3c() {
    	/* Setup paint */
        paint = new Paint();
        paint.setColor(Color.argb(100, 50, 100, 200));
        paint.setTextSize(32f);

        /* We store all drawables in this list and later draw all drawables in this list */
        drawables = new ArrayList<ShapeDrawable>();

        touchShape = new OvalShape();
        touchShape.resize(50, 50);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new MyView(this));
    }

    /* Our custom view which will draw the drawables in list 
     * and will listen to touch events */
    private class MyView extends View implements View.OnTouchListener {
        public MyView(Context context) {
            super(context);
            setOnTouchListener(this);
        }

        /* Draw all drawables in the list! */
        @Override
        protected void onDraw(Canvas canvas) {
            for (ShapeDrawable drawable : drawables) {
                drawable.draw(canvas);
            }
        }

        /* Add new drawable at touched position */
        public boolean onTouch(View v, MotionEvent me) {
            ShapeDrawable drawable = new ShapeDrawable(touchShape);
            drawable.getPaint().set(paint);
            drawable.setBounds((int) me.getX() - 25, (int) me.getY() - 25,
                    (int) me.getX() + 25, (int) me.getY() + 25);
            drawables.add(drawable);
            invalidate();
            return true;
        }
    }
}
