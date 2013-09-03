package com.example.fillneed;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

public class Userprofile extends Activity {
	 ListView list_home;
	    CustomListAdapter adapter;
	    ArrayList<Item> list_details = new ArrayList<Item>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		setContentView(R.layout.activity_userprofile);
		ScrollView scroll=(ScrollView)findViewById(R.id.mainscroll);
		ImageView img=(ImageView)findViewById(R.id.imageView1);
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
		 
			scroll.scrollTo(0, img.getTop());

	}
		
 

}
