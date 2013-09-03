package com.example.fillneed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		ImageView leaf1 =(ImageView)findViewById(R.id.leaf1);
		ImageView leaf2 =(ImageView)findViewById(R.id.leaf2);
		ImageView leaf3 =(ImageView)findViewById(R.id.leaf3);
		ImageView login_facebook =(ImageView)findViewById(R.id.login_facebook);
		ImageView login_twitter =(ImageView)findViewById(R.id.login_twitter);


		leaf1.startAnimation( 
			    AnimationUtils.loadAnimation(this, R.anim.rotate1) );
		
		leaf2.startAnimation( 
			    AnimationUtils.loadAnimation(this, R.anim.rotate2) );
		leaf3.startAnimation( 
			    AnimationUtils.loadAnimation(this, R.anim.rotate3) );
		
		login_facebook.setOnClickListener(new OnClickListener() 
		   {
		    @Override          
		    public void onClick(View v) 
		    {              
		    	Intent myIntent = new Intent(Splash.this, MainActivity.class);
		    	Splash.this.startActivity(myIntent);
		    	overridePendingTransition(R.anim.fade_in, R.anim.fade_out); 		    }         
		   });		
		
		login_twitter.setOnClickListener(new OnClickListener() 
		   {
		    @Override          
		    public void onClick(View v) 
		    {              
		    	Intent myIntent = new Intent(Splash.this, Ngohome.class);
		    	Splash.this.startActivity(myIntent);
		    	overridePendingTransition(R.anim.fade_in, R.anim.fade_out); 		    }         
		    	       
		   });	
		
	}

 
}
