package com.projetioc.seisme.modele;

public class Seisme {
	
	private String nom;
	private String latitude;
	private String longitude;
	private String magnitude;
	private String localisation;
	private String nombreStations;
	
	public String getNombreStations() {
		return nombreStations;
	}

	public void setNombreStations(String nombreStations) {
		this.nombreStations = nombreStations;
	}

	public Seisme()
	{
		nom = "";
		latitude = "";
		longitude = "";
		magnitude =  "";
		localisation = "";
		
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}


	
}
