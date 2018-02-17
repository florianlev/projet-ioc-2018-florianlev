package com.projetioc.seisme;

import com.projetioc.seisme.action.ControleurSeisme;
import com.projetioc.seisme.vue.SeismeVue;

import com.projetioc.seisme.action.ControleurSeisme;

public class SeismeApp {
	
	SeismeVue seismeVue;

	public static void main(String[] parametres) {
		// TODO Auto-generated method stub
		
		SeismeVue seismeVue = new SeismeVue();
		SeismeVue.launch(SeismeVue.class, parametres);


		
	}

}
