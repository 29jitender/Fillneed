package com.example.fillneed;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class Item_detail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		    getActionBar().hide();
		setContentView(R.layout.activity_item_detail);
		Button call =(Button) findViewById(R.id.detail_call);
		
		call.setOnClickListener(new OnClickListener() {

	        public void onClick(View v) {
	            try {
	                    Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+"9910752225"));
	                    startActivity(callIntent);
	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }
	        }
	    });
	}

 

}
