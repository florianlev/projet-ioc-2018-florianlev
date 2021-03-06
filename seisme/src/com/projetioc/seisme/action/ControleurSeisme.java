package com.projetioc.seisme.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.projetioc.seisme.dao.DaoSeisme;
import com.projetioc.seisme.modele.ListeDesVilles;
import com.projetioc.seisme.modele.Seisme;
import com.projetioc.seisme.modele.Ville;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projetioc.seisme.vue.SeismeVue;

public class ControleurSeisme {
	
	protected SeismeVue vue;
	List<String> listeVille;
	
	
	
	public ControleurSeisme(SeismeVue vue)
	{
		this.vue = vue;
		listeVille = new ArrayList<>();
		
	
	}
	
	public void afficherOnglets()
	{
		
		
		
		ApplicationContext contexte =
				new ClassPathXmlApplicationContext("com/projetioc/seisme/modele/Villes.xml");
		
		Ville britishVirginIsland = (Ville)contexte.getBean("britishVirginIsland");
		
		
		Ville dominicanRepublic = (Ville)contexte.getBean("dominicanRepublic");
		
		Ville puertoRico = (Ville)contexte.getBean("puertoRico");
		
		Ville california = (Ville)contexte.getBean("california");
		
		Ville alaska = (Ville)contexte.getBean("alaska");
		
		
		listeVille.add(britishVirginIsland.getNom());
		listeVille.add(dominicanRepublic.getNom());
		listeVille.add(puertoRico.getNom());
		listeVille.add(california.getNom());
		listeVille.add(alaska.getNom());
		
		
		
		vue.afficherMenu("Mondiale", 1);
		vue.afficherMenu(britishVirginIsland.getNom(), 2);
		vue.afficherMenu(dominicanRepublic.getNom(), 3);
		vue.afficherMenu(puertoRico.getNom(), 4);
		vue.afficherMenu(california.getNom(), 5);
		vue.afficherMenu(alaska.getNom(), 6);
		
		List<String> listeMondiale = new ArrayList<String>();
		List<String> listeBritishVirginIsland = new ArrayList<String>();
		List<String> listeDominicanRepublic = new ArrayList<String>();
		List<String> listePuertoRico = new ArrayList<String>();
		List<String> listeCalifornia = new ArrayList<String>();
		List<String> listeAlaska = new ArrayList<String>();
		
		
		
		DaoSeisme daoSeisme = new DaoSeisme();
		
		
		for (int i = 0; i < listeVille.size(); i++)
		{
			
			List<Seisme> listeSeismeVille = daoSeisme.getRechercherVilleSeisme(listeVille.get(i));
			for (Seisme seisme : listeSeismeVille)
			{
				switch (listeVille.get(i))
				{
					case "British Virgin Island":
						
						listeBritishVirginIsland.add(seisme.getNom());
						listeBritishVirginIsland.add(seisme.getMagnitude());
						listeBritishVirginIsland.add(seisme.getLocalisation());
						listeBritishVirginIsland.add(seisme.getNombreStations());
						
						break;
					case "Dominican Republic":
						
						listeDominicanRepublic.add(seisme.getNom());
						listeDominicanRepublic.add(seisme.getMagnitude());
						listeDominicanRepublic.add(seisme.getLocalisation());
						listeDominicanRepublic.add(seisme.getNombreStations());
						break;
						
					case "Puerto Rico":
						
						listePuertoRico.add(seisme.getNom());
						listePuertoRico.add(seisme.getMagnitude());
						listePuertoRico.add(seisme.getLocalisation());
						listePuertoRico.add(seisme.getNombreStations());
						
						break;
					case "California":
						
						listeCalifornia.add(seisme.getNom());
						listeCalifornia.add(seisme.getMagnitude());
						listeCalifornia.add(seisme.getLocalisation());
						listeCalifornia.add(seisme.getNombreStations());						break;
					case "Alaska":
						
						listeAlaska.add(seisme.getNom());
						listeAlaska.add(seisme.getMagnitude());
						listeAlaska.add(seisme.getLocalisation());
						listeAlaska.add(seisme.getNombreStations());	
						break;
				}
			
			}
			daoSeisme.nettoyerListeVille();


		}
		//System.out.println(listeBritishVirginIsland);
		
		
		List<Seisme> listeSeisme = daoSeisme.getRechercherMondialSeisme();
		
		for (Seisme seisme : listeSeisme)
	
			{
				listeMondiale.add(seisme.getNom()); 
				listeMondiale.add(seisme.getMagnitude());
				listeMondiale.add(seisme.getLatitude()); 
				listeMondiale.add(seisme.getLongitude());
			
			
			seisme.getLongitude();
			}

		

		
		
		vue.afficherListe(listeMondiale, 1);
		vue.afficherListe(listeBritishVirginIsland, 2);
		vue.afficherListe(listeDominicanRepublic, 3);
		vue.afficherListe(listePuertoRico, 4);
		vue.afficherListe(listeCalifornia, 5);
		vue.afficherListe(listeAlaska, 6);
		
		
	}
	

}
