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
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.slidinglayer.SlidingLayer;
 
public class MainActivity extends Activity {

    private SlidingLayer slide_buttom;
    private SlidingLayer slide_right;

 	 ListView lv1;
	    CustomListAdapter adapter;
	    ArrayList<Item> list_details = new ArrayList<Item>();

    private String slidepanel_fromwhere;
    private boolean mShowShadow;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
        setContentView(R.layout.activity_main);
        slidepanel_fromwhere = "bottom";
        mShowShadow = true;
     	this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); //open only keyboard when user click
    	
        bindViews("bottom");
      

        ///////listview
///////for list and some random animation
        
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
    	
        for(int i=0;i<10;i++){     	
    
    	Item data = new Item();
        data.settitle("Item "+i);    
        data.setlocation("Delhi");
        data.seturl("https://si0.twimg.com/profile_images/3690637553/5c348fee8afbcefa1978004a864a51ce.png");
        list_details.add(data);
        }
 		    lv1 = (ListView) findViewById(R.id.custom_list);
		adapter=new CustomListAdapter(this, list_details);
		lv1.setAdapter(adapter);
	 
		lv1.setLayoutAnimation(controller);
 
                
        ///////////
        
        
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
             initState("bottom",slide_buttom,true);

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
    }

    public void buttonClicked(View v) {
        switch (v.getId()) {
        case R.id.filter:
        	 if (!slide_right.isOpened()) {
        		 slide_right.openLayer(true);
 
             }
            //slide_right.closeLayer(true);
            Log.i("sad","Asdas");

        	break;
        case R.id.need_post:
                 slide_buttom.closeLayer(true);
                 Log.i("ccc","ccc");
            
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
}
