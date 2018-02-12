package com.projetioc.seisme;

import com.projetioc.seisme.action.ControleurSeisme;
import com.projetioc.seisme.vue.SeismeVue;

import com.projetioc.seisme.action.ControleurSeisme;

public class SeismeApp {
	
	SeismeVue seismeVue;

	public static void main(String[] parametres) {
		// TODO Auto-generated method stub
		
		SeismeVue seismeVue = new SeismeVue();
		ControleurSeisme controleur = new ControleurSeisme(seismeVue);
		SeismeVue.launch(SeismeVue.class, parametres);
		//seismeVue.afficherMenu(parametres, "test", 5);

		
	}

}
