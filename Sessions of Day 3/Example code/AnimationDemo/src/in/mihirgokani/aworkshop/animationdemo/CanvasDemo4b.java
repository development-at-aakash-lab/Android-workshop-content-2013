package in.mihirgokani.aworkshop.animationdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * @author Mihir Gokani
 * @created 26-Feb-2013 2:20:17 PM
 * 
 * Demo of how NOT to "redraw" 
 */
public class CanvasDemo4b extends Activity {

    final Paint paint;
    ShapeDrawable drawable;

    /**
     * Constructor for CanvasDemo3b
     */
    public CanvasDemo4b() {
        paint = new Paint();
        paint.setColor(Color.argb(100, 50, 100, 200));
        paint.setTextSize(32f);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Shape shape;

        shape = new OvalShape();
        shape.resize(50, 50);

        drawable = new ShapeDrawable(shape);
        drawable.getPaint().set(paint);
        drawable.setBounds(125, 225, 275, 375);

        setContentView(new MyView(this));
    }

    private class MyView extends View implements OnTouchListener {

        private static final int MAX_STEPS = 100;
        private int maxSteps;

        public MyView(Context context) {
            super(context);
            this.maxSteps = MAX_STEPS;
            setOnTouchListener(this);
        }

        /* NOTE: This is to demonstrate how you should NOT do!! */
        @Override
        protected void onDraw(Canvas canvas) {
            if (maxSteps < MAX_STEPS) {
                canvas.save();
                drawable.draw(canvas);
                canvas.translate(5 * maxSteps, 0);
                maxSteps++;
                canvas.restore();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                invalidate();
            }
        }

        /* NOTE: This is to demonstrate how you should NOT do!! */
        @Override
        public boolean onTouch(View view, MotionEvent me) {
            this.maxSteps = 0;
            invalidate();
            return false;
        }
    }

}
