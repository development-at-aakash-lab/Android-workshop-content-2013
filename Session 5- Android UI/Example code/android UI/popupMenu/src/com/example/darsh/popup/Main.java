package com.example.darsh.popup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

public class Main extends Activity {

	private LayoutInflater inflater;
	private PopupWindow pw;
	private View popupView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		popupView = inflater.inflate(R.layout.menu_layout, null, false);
	}

	public void showPopup(View view) {
		pw = new PopupWindow(getApplicationContext());
		pw.setTouchable(true);
		pw.setFocusable(true);
		pw.setOutsideTouchable(true);
		pw.setTouchInterceptor(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					pw.dismiss();

					return true;
				}

				return false;
			}
		});

		pw.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
		pw.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		pw.setOutsideTouchable(false);
		pw.setContentView(popupView);
		pw.showAsDropDown(view, 0, 0);

	}

	public void clickOne(View view) {
		pw.dismiss();
		Toast.makeText(getBaseContext(), "Tapped SEARCH", Toast.LENGTH_SHORT)
				.show();
	}

	public void clickTwo(View view) {

		pw.dismiss();
		Toast.makeText(getBaseContext(), "Tapped REFRESH", Toast.LENGTH_SHORT)
				.show();
	}

	public void clickThree(View view) {
		pw.dismiss();
		Toast.makeText(getBaseContext(), "Tapped SHARE", Toast.LENGTH_SHORT)
				.show();
	}
}