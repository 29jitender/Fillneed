/*
 * MainActivity.java
 * 
 * Copyright (C) 2013 6 Wunderkinder GmbH.
 * 
 * @author      Jose L Ugia - @Jl_Ugia
 * @author      Antonio Consuegra - @aconsuegra
 * @author      Cesar Valiente - @CesarValiente
 * @author      Benedikt Lehnert - @blehnert
 * @author      Timothy Achumba - @iam_timm
 * @version     1.0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.fillneed;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.slidinglayer.SlidingLayer;
 
public class Ngohome extends Activity implements LocationListener {
    LocationManager mLocationManager;
    TextView user_location;
    Location location;
    private SlidingLayer slide_buttom;
    private SlidingLayer slide_right;
    ImageView clickedpicture;
    String fileName = "temp.jpg";  
    Uri mCapturedImageURI;
 	 ListView list_home;
	    CustomListAdapter adapter;
	    ArrayList<Item> list_details = new ArrayList<Item>();
    private String slidepanel_fromwhere;
    private boolean mShowShadow;
    String capturedImageFilePath;
    String latitud ;
    String longitude;
    String ongitud ;
    String[] item_name={"Delhi","Noida","Delhi","Assam","Hyd","Delhi","guj","panji","Banglor","Jaipur"};
    String[] item_imageurl={"Delhi","Noida","Delhi","Assam","Hyd","Delhi","guj","panji","Banglor","Jaipur"};
    String[] item_location={"https://m.ak.fbcdn.net/sphotos-h.ak/hphotos-ak-prn1/311384_260039760694627_1693173061_n.jpg","https://m.ak.fbcdn.net/sphotos-b.ak/hphotos-ak-prn1/1234128_10201915634991327_1335961593_n.jpg","https://m.ak.fbcdn.net/sphotos-h.ak/hphotos-ak-prn1/76314_10151844978648132_2075543312_n.jpg","Assam","Hyd","Delhi","guj","panji","Banglor","Jaipur"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
        setContentView(R.layout.activity_main);
        slidepanel_fromwhere = "bottom";
        mShowShadow = false;
     	this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); //open only keyboard when user click
    	
     	TextView t1=(TextView)findViewById(R.id.home_username);
     	t1.setText("Plan India");
     	String[] item_name={"Isha has Donated 10 blankets",
        		"Goonj collected book from Sahil",
        		"Goonj just entered the silver leauge",
        		"Arun upvoted Helpage India",
        		"Isha has Donated 10 blankets","Goonj collected book from Sahil","Goonj just entered the silver leauge","Arun upvoted Helpage India",
        		"Goonj just entered the silver leauge",
        		"Arun upvoted Helpage India"};
        String[] item_imagelocation={"Delhi","Noida","Delhi","Assam","Hyderabad","Delhi","Gujarat","Go","Bangalore","Jaipur"};
        String[] item_locationurl={"https://m.ak.fbcdn.net/sphotos-h.ak/hphotos-ak-prn1/311384_260039760694627_1693173061_n.jpg",
        		"https://m.ak.fbcdn.net/sphotos-e.ak/hphotos-ak-ash4/1002539_10151785395248784_661839182_n.jpg",
        		"http://www.ecowalkthetalk.com/blog/wp-content/uploads/2010/08/Goonj-Logo.png",
        		"https://m.ak.fbcdn.net/sphotos-h.ak/hphotos-ak-prn1/76314_10151844978648132_2075543312_n.jpg","https://m.ak.fbcdn.net/sphotos-e.ak/hphotos-ak-ash4/1002539_10151785395248784_661839182_n.jpg","https://m.ak.fbcdn.net/sphotos-h.ak/hphotos-ak-prn1/76314_10151844978648132_2075543312_n.jpg","https://m.ak.fbcdn.net/sphotos-b.ak/hphotos-ak-prn1/1234128_10201915634991327_1335961593_n.jpg","https://m.ak.fbcdn.net/sphotos-e.ak/hphotos-ak-ash4/1002539_10151785395248784_661839182_n.jpg","https://m.ak.fbcdn.net/sphotos-h.ak/hphotos-ak-prn1/311384_260039760694627_1693173061_n.jpg","https://m.ak.fbcdn.net/sphotos-h.ak/hphotos-ak-prn1/76314_10151844978648132_2075543312_n.jpg"};
     
        bindViews("bottom");
      

        ///////listview
///////for list and some random animation
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

          location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            user_location =(TextView)findViewById(R.id.need_location);
       	
        if(location != null) {            
        	latitud=location.getLatitude()+"";
        	longitude=location.getLongitude()+"";
        	Log.i("1","dasd"+location.getLatitude()+"--------- "+location.getLongitude());
        	user_location.setText("noida");	
        }
        else {
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            Log.i("dasd","dasd");
            user_location.setText("delhi");
        }
        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 0.0f);//1.0f
        animation.setDuration(50);
        set.addAnimation(animation);

        animation = new TranslateAnimation(
            Animation.RELATIVE_TO_SELF, 0.0f,Animation.RELATIVE_TO_SELF, 0.0f,
            Animation.RELATIVE_TO_SELF, -1.0f,Animation.RELATIVE_TO_SELF, 0.0f
        );
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);
    	
        for(int i=0;i<item_locationurl.length;i++){     	
            
        	Item data = new Item();
            data.settitle(item_name[i]);    
            data.setlocation(item_imagelocation[i] );
            
            data.seturl(item_locationurl[i]);
            list_details.add(data);
            }
 		    list_home = (ListView) findViewById(R.id.custom_list);
		adapter=new CustomListAdapter(this, list_details);
		list_home.setAdapter(adapter);
	 
		list_home.setLayoutAnimation(controller);
			
		list_home.setOnItemClickListener(new OnItemClickListener() {

 			@Override
 			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
 				Object o = list_home.getItemAtPosition(position);
 				Item newsData = (Item) o;
 				 String pass =newsData.toString();
 				String name = pass.substring(0, pass.indexOf(','));
 			 	Intent myIntent = new Intent(Ngohome.this, Item_detail.class);
		    	Ngohome.this.startActivity(myIntent);
		    	overridePendingTransition(R.anim.fade_in, R.anim.fade_out); 			
 			 
 			}

 		});	
		
		
		
		
		
		
		
		
		ImageView profile=(ImageView)findViewById(R.id.home_userimage);
		profile.setImageResource(R.drawable.ngoimage);
		profile.setOnClickListener(new OnClickListener() 
		   {
		    @Override          
		    public void onClick(View v) 
		    {              
		    	Intent myIntent = new Intent(Ngohome.this, Userprofile.class);
		    	Ngohome.this.startActivity(myIntent);
		    	overridePendingTransition(R.anim.fade_in, R.anim.fade_out); 	
		    
		    	}         
		   });	
                
        ///////////
		
        
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == 1000 && resultCode == RESULT_OK) {  
        	 String[] projection = { MediaStore.Images.Media.DATA}; 
             @SuppressWarnings("deprecation")
			Cursor cursor = managedQuery(mCapturedImageURI, projection, null, null, null); 
             int column_index_data = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA); 
             cursor.moveToFirst(); 
               capturedImageFilePath = cursor.getString(column_index_data);
 			AQuery aq = new AQuery(this);

         	boolean memCache = false;
        	boolean fileCache = true;

        	aq.id(R.id.click_image).image(capturedImageFilePath, memCache, fileCache);
         }  
    }  
    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
 
    }

    /**
     * View binding
     */
    private void bindViews(String direction) {
        slide_buttom = (SlidingLayer) findViewById(R.id.slidingLayer1);
        slide_right = (SlidingLayer) findViewById(R.id.slidingLayer_right);
        LayoutParams rlp = (LayoutParams) slide_right.getLayoutParams();

        slide_right.setStickTo(SlidingLayer.STICK_TO_RIGHT);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rlp.height = LayoutParams.MATCH_PARENT;
        rlp.width = getResources().getDimensionPixelSize(R.dimen.layer_width_left);
    	if(direction.equals("bottom")){
             initState("bottom",slide_buttom,false);

    	}
    	else if(direction.equals("right")){
            initState("right",slide_right,false);

    	}
     }

    
    /**
     * Initializes the origin state of the layer
     */
    private void initState(String what,SlidingLayer layer,boolean mShowOffset) {

        // Sticks container to right or left
        LayoutParams rlp = (LayoutParams) layer.getLayoutParams();
  
        if (what.equals("right")) {
  
            //rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            slide_right.setStickTo(SlidingLayer.STICK_TO_RIGHT);
            rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            rlp.height = LayoutParams.MATCH_PARENT;
            rlp.width = getResources().getDimensionPixelSize(R.dimen.layer_width_left);
            
        } else if (what.equals("left")) {
  
            rlp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        } else if (what.equals("top")) {
  
            slide_buttom.setStickTo(SlidingLayer.STICK_TO_TOP);
            rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            rlp.width = LayoutParams.MATCH_PARENT;
            rlp.height = getResources().getDimensionPixelSize(R.dimen.layer_width);
        } else if (what.equals("bottom")) {
  
            slide_buttom.setStickTo(SlidingLayer.STICK_TO_BOTTOM);
            rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            rlp.width = LayoutParams.MATCH_PARENT;
            rlp.height = getResources().getDimensionPixelSize(R.dimen.layer_width);
        } else {
   
        }

 
        // Sets the shadow of the container
        if (mShowShadow) {
            slide_buttom.setShadowWidthRes(R.dimen.shadow_width);
            slide_buttom.setShadowDrawable(R.drawable.sidebar_shadow);
        } else {
            slide_buttom.setShadowWidth(0);
            slide_buttom.setShadowDrawable(null);
        }
        if(mShowOffset) {
            slide_buttom.setOffsetWidth(getResources().getDimensionPixelOffset(R.dimen.offset_width));
        } else {
            slide_buttom.setOffsetWidth(0);
        }
          clickedpicture=(ImageView)findViewById(R.id.click_image);
    	clickedpicture.setOnClickListener(new OnClickListener() //storing image
     		   {
     		    @Override          
     		    public void onClick(View v) 
     		    {              
     		   	
   		    	 ContentValues values = new ContentValues();  
   		         values.put(MediaStore.Images.Media.TITLE, fileName);  
   		         mCapturedImageURI = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);  

   		         Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  
   		         intent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);  
   		         startActivityForResult(intent, 1000);
     		    }         
		    	       
		   });	         
    }

    public void buttonClicked(View v) {
        switch (v.getId()) {
        case R.id.filter:
        	 if (!slide_right.isOpened()) {
        		 slide_right.openLayer(true);
 
             }
            //slide_right.closeLayer(true);

        	break;
        case R.id.need_post:
        	InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        	imm.hideSoftInputFromWindow(slide_buttom.getWindowToken(), 0);
             	EditText user_id =(EditText)findViewById(R.id.item_name);
             	
            	final String userid=user_id.getText().toString();
            	final String location=user_location.getText().toString();
            	 	  runOnUiThread(new Runnable() {
              	  public void run() {
              		Item data = new Item();
                    data.settitle(userid);    
                    data.setlocation(location);                    
                    data.seturl(capturedImageFilePath);
                    list_details.add(0,data);
                    adapter.notifyDataSetChanged();

              		  
              	  }	});
            	
            	 	  
            	user_id.setText("");
            	user_location.setText("");
                Log.i("done",userid+location);
         		slide_buttom.closeLayer(true);
         		user_id.setText("");
            	user_location.setText("");
            	clickedpicture.setImageResource(R.drawable.ic_launcher);
         		
            break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_BACK:
            if (slide_buttom.isOpened()) {
                slide_buttom.closeLayer(true);
                return true;
            }

        default:
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
	@Override
	public void onLocationChanged(Location arg0) {
		if (location != null) {
            Log.v("Location Changed", location.getLatitude() + " and " + location.getLongitude());
        }		
	}
	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
}
