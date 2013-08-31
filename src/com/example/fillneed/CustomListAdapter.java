package com.example.fillneed;

import java.util.ArrayList;

import com.example.fillneed.R;
 import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.BitmapAjaxCallback;
public class CustomListAdapter extends BaseAdapter {

	private ArrayList<Item> listData;
	private ArrayList<Item> arraylist;


	private LayoutInflater layoutInflater;

	public CustomListAdapter(Context context, ArrayList<Item> listData) {
		this.listData = listData;
		layoutInflater = LayoutInflater.from(context);
		
		this.arraylist = new ArrayList<Item>();
        this.arraylist.addAll(listData);
	}

	@Override
	public int getCount() {
		return listData.size();
	}

	@Override
	public Object getItem(int position) {
		return listData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
 			convertView = layoutInflater.inflate(R.layout.list_layout, null);
			holder = new ViewHolder();
			holder.headlineView = (TextView) convertView.findViewById(R.id.itemname);
 			holder.location = (TextView) convertView.findViewById(R.id.item_location);
			holder.imageItem = (ImageView) convertView.findViewById(R.id.item_image);
 
 			convertView.setTag(holder);
	 

		Item newsItem = (Item) listData.get(position);

		holder.headlineView.setText(newsItem.gettitle());
  		holder.location.setText(newsItem.getlocation());
		if (holder.imageItem != null) {
  			String imageUrl = newsItem.geturl();
			AQuery aq = new AQuery(convertView);

			aq.id(holder.imageItem).image(imageUrl, true, true, 0, 0, new BitmapAjaxCallback(){

		        @Override
		        public void callback(String url, ImageView iv, Bitmap bm, AjaxStatus status){
 		            Log.i("image","sucess"+url);    
		        	iv.setImageBitmap(bm);
		                    
		        }
		        
		});
			
			
 		}
 
		return convertView;
	}
	 
	static class ViewHolder {
		TextView headlineView;
 		TextView location;
 
		ImageView imageItem;
	}
	
	 
}
