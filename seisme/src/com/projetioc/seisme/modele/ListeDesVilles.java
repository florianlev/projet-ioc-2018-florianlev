package com.projetioc.seisme.modele;

import java.util.ArrayList;
import java.util.List;

public class ListeDesVilles {

	protected List<Ville> listeVilles = new ArrayList<Ville>();
	
	public List<Ville> getListeVilles()
	{
		return listeVilles;
	}
	
	public void setListeVilles(List<Ville> listeVilles)
	{
		this.listeVilles = listeVilles;
	}
		

}
