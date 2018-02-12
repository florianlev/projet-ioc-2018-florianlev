package com.projetioc.seisme;

import com.projetioc.seisme.vue.SeismeVue;

public class SeismeApp {

	public static void main(String[] parametres) {
		// TODO Auto-generated method stub
		
		SeismeVue seismeVue = new SeismeVue();
		
		SeismeVue.launch(SeismeVue.class, parametres);
		//seismeVue.afficherMenu(parametres, "test", 5);
	}

}
