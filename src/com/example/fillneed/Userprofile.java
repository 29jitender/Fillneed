package com.example.fillneed;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Userprofile extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		setContentView(R.layout.activity_userprofile);
	}

 

}
