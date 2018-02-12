package com.projetioc.seisme.action;
import java.util.ArrayList;
import java.util.List;

import com.projetioc.seisme.vue.SeismeVue;

public class ControleurSeisme {
	
	protected SeismeVue vue = null;
	
	public ControleurSeisme(SeismeVue vue)
	{
		this.vue = vue;
		
		vue.afficherMenu("Mondial", 1);
		vue.afficherMenu("San Diego", 2);
		vue.afficherMenu("Montreal", 3);
		
		List<String> listeMondiale = new ArrayList<String>();
		listeMondiale.add("bla");
		vue.afficherListe(listeMondiale, 1);
		
	}
	

}
