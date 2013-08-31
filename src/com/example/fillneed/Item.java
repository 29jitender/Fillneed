package com.example.fillneed;

public class Item {
	private String headline;
	 
	private String streak;
	private String userid;
	private String url;
 
	public String geturl(){
		return url;
	}
	public void seturl(String url){
		this.url=url;
	}
	
	
	public String getlocation(){
		return streak;
	}
	public void setlocation(String streak){
		this.streak=streak;
	}
	
	 

	public String gettitle() {
		return headline;
	}

	public void settitle(String headline) {
		this.headline = headline;
	}

	 

	 

	@Override
	public String toString() {
		return headline+","+userid;
	}
}
