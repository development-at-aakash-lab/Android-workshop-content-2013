package com.example.webapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


public class Browser extends Activity {

	EditText urlText; // edit text for search url
	Button search,forward,backward,refresh,hist; // button declaration
	
	WebView browser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// initialization of objects
		urlText = (EditText)findViewById(R.id.url); 
	    search = (Button)findViewById(R.id.bsearch);
		
	    forward = (Button) findViewById(R.id.bforw);
		backward = (Button) findViewById(R.id.bback);
		refresh = (Button) findViewById(R.id.bref);
		hist = (Button) findViewById(R.id.bhist);
		
		browser = (WebView) findViewById(R.id.webEngine);
		browser.setWebViewClient(new myWebviewClient());
		browser.getSettings().setJavaScriptEnabled(true);
		
		//browser.loadData("<html><body><h1>This is Android</h1></body></html>", "text/html", "UTF-8");
		browser.loadUrl("http://www.google.co.in/");
		
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String webSiteName = urlText.getText().toString();
				browser.loadUrl(webSiteName);
			}
		});
		
		backward.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(browser.canGoBack())
					browser.goBack();
			}
		});
		
		forward.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(browser.canGoForward())
					browser.goForward();
			}
		});
		
		refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				browser.reload();
			}
		});
		
		hist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				browser.clearHistory();
			}
		});
		
	}

}
