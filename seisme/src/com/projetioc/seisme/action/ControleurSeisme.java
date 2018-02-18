package com.projetioc.seisme.action;
import java.util.ArrayList;
import java.util.List;
import com.projetioc.seisme.modele.Ville;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projetioc.seisme.vue.SeismeVue;

public class ControleurSeisme {
	
	protected SeismeVue vue;
	
	
	public ControleurSeisme(SeismeVue vue)
	{
		this.vue = vue;
	
	}
	
	public void afficherOnglets()
	{
		
		vue.afficherMenu("Mondial", 1);
		vue.afficherMenu("San Diego", 2);
		vue.afficherMenu("Montreal", 3);
		vue.afficherMenu("Los angeles", 4);
		vue.afficherMenu("Tokyo", 5);
		
		List<String> listeMondiale = new ArrayList<String>();
		List<String> listeSanDiego = new ArrayList<String>();
		List<String> listeMontreal = new ArrayList<String>();
		List<String> listeLosAngeles = new ArrayList<String>();
		List<String> listeTokyo = new ArrayList<String>();
		
		listeMondiale.add("seisme1");
		listeMondiale.add("seisme2");
		listeMondiale.add("seisme3");
		
		listeSanDiego.add("sexcvxisme1");
		listeSanDiego.add("seismadsgfe2");
		listeSanDiego.add("seismxcvxcv3");
		
		listeMontreal.add("seisme1");
		listeMontreal.add("seisme2");
		listeMontreal.add("seisme3");
		
		listeLosAngeles.add("seisme1");
		listeLosAngeles.add("seisme2");
		listeLosAngeles.add("seisme3");
		
		listeTokyo.add("seisme1");
		listeTokyo.add("seisme2");
		listeTokyo.add("seisme3");
		
		
		
		
		
		vue.afficherListe(listeMondiale, 1);
		vue.afficherListe(listeSanDiego, 2);
		vue.afficherListe(listeMontreal, 3);
		vue.afficherListe(listeLosAngeles, 4);
		vue.afficherListe(listeTokyo, 5);
		
		
	}
	

}
