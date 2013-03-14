package in.mihirgokani.aworkshop.animationdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

/**
 * @author Mihir Gokani
 * @created 25-Feb-2013 2:40:11 AM
 * 
 * Simple Canvas demo: Using {@link Canvas#drawXXX()} methods. 
 */
public class CanvasDemo1 extends Activity {

    final float cx, cy, radius; // Center and radius of circle
    final float posx, posy; // Text position
    final float left, top, right, bottom; // Rectangle bounds
    final String text; // Text
    final Paint paint; // Paint

    /**
     * Constructor for CanvasDemo1
     */
    public CanvasDemo1() {
    	/* Setup position, radius, text, etc. */
    	cx = 200;
        cy = 300;
        radius = 75;

        posx = 800;
        posy = 300;

        left = 475;
        top = 225;
        right = 625;
        bottom = 375;

        text = "Akash Workshop";

    	/* Setup paint */
        paint = new Paint();
        paint.setColor(Color.argb(100, 50, 100, 200));
        paint.setTextSize(32f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    /* Our custom view which will draw on the canvas */
    private class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        /* Draw a circle, rectangle, and some text on Canvas */
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(cx, cy, radius, paint);
            canvas.drawRect(left, top, right, bottom, paint);
            canvas.drawText(text, posx, posy, paint);
        }
    }
}
