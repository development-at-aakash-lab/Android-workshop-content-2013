package in.mihirgokani.aworkshop.animationdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

/**
 * @author Mihir Gokani
 * @created 25-Feb-2013 1:10:19 AM
 */
public class CanvasDemo2 extends Activity {

    final Paint paint;
    private Bitmap bitmap;

    /**
     * Constructor for CanvasDemo3b
     */
    public CanvasDemo2() {
    	/* Setup paint */
        paint = new Paint();
        paint.setColor(Color.argb(100, 50, 100, 200));
        paint.setTextSize(32f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher);
        bitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false);

        setContentView(new MyView(this));
    }

    /* Our custom view which will draw the drawable */
    private class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(bitmap, 0, 0, paint);
        }
    }

}
