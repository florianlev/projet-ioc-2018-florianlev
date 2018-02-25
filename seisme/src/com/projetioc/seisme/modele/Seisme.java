package com.projetioc.seisme.modele;

public class Seisme {
	
	private int earthQuakeID;
	private float latitude;
	private float longitude;
	private float magnitude;
	
	
	public int getEarthQuakeID() {
		return earthQuakeID;
	}
	public void setEarthQuakeID(int earthQuakeID) {
		this.earthQuakeID = earthQuakeID;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(float magnitude) {
		this.magnitude = magnitude;
	}
	
	
}
