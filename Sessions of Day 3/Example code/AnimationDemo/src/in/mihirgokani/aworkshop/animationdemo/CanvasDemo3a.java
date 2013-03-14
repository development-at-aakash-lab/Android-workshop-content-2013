package in.mihirgokani.aworkshop.animationdemo;

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
import android.view.View;

/**
 * @author Mihir Gokani
 * @created 25-Feb-2013 2:40:47 AM
 * 
 * Using {@link Drawable#draw(Canvas)} method. 
 */
public class CanvasDemo3a extends Activity {

    final Paint paint;

    ShapeDrawable myShapeDrawable;

    /**
     * Constructor for CanvasDemo3b
     */
    public CanvasDemo3a() {
    	/* Setup paint */
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

        myShapeDrawable = new ShapeDrawable(shape);
        myShapeDrawable.getPaint().set(paint);
        myShapeDrawable.setBounds(125, 225, 275, 375);

        setContentView(new MyView(this));
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
