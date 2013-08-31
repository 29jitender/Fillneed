package com.example.fillneed;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		ImageView leaf1 =(ImageView)findViewById(R.id.leaf1);
		ImageView leaf2 =(ImageView)findViewById(R.id.leaf2);
		ImageView leaf3 =(ImageView)findViewById(R.id.leaf3);

		leaf1.startAnimation( 
			    AnimationUtils.loadAnimation(this, R.anim.rotate1) );
		
		leaf2.startAnimation( 
			    AnimationUtils.loadAnimation(this, R.anim.rotate2) );
		leaf3.startAnimation( 
			    AnimationUtils.loadAnimation(this, R.anim.rotate3) );
		
	}

 
}
