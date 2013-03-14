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
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.View;

/**
 * @author Mihir Gokani
 * @created 25-Feb-2013 2:40:47 AM
 * 
 * Drawing many {@link Drawable}s at once (stored in {@link ArrayList}).
 */
public class CanvasDemo3b extends Activity {

    final Paint paint;
    final ArrayList<ShapeDrawable> drawables;

    /**
     * Constructor for CanvasDemo3b
     */
    public CanvasDemo3b() {
    	/* Setup paint */
        paint = new Paint();
        paint.setColor(Color.argb(100, 50, 100, 200));
        paint.setTextSize(32f);
        
        /* We store all drawables in this list and later draw all drawables in this list */
        drawables = new ArrayList<ShapeDrawable>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Shape shape;
        ShapeDrawable drawable;

        /* Setup Circle */
        shape = new OvalShape();
        shape.resize(50, 50);

        drawable = new ShapeDrawable(shape);
        drawable.getPaint().set(paint);
        drawable.setBounds(125, 225, 275, 375);
        drawables.add(drawable); // Add it to our list!

        /* Setup Rectangle */
        shape = new RectShape();
        shape.resize(50, 50);

        drawable = new ShapeDrawable(shape);
        drawable.getPaint().set(paint);
        drawable.setBounds(475, 225, 625, 375);
        drawables.add(drawable); // Add it to our list!

        setContentView(new MyView(this));
    }

    /* Our custom view which will draw the drawables in list */
    private class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        /* Draw all drawables in the list! */
        @Override
        protected void onDraw(Canvas canvas) {
            for (ShapeDrawable drawable : drawables) {
                drawable.draw(canvas);
            }
        }
    }

}
