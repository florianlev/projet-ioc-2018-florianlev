package com.projetioc.seisme;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projetioc.seisme.action.ControleurSeisme;
import com.projetioc.seisme.modele.Ville;
import com.projetioc.seisme.vue.SeismeVue;

import com.projetioc.seisme.action.ControleurSeisme;

public class SeismeApp {
	
	SeismeVue seismeVue;

	public static void main(String[] parametres) {
		// TODO Auto-generated method stub
		ApplicationContext contexte =
				new ClassPathXmlApplicationContext("com/projetioc/seisme/modele/villes.xml");
		
		Ville sandiego = (Ville)contexte.getBean("SanDiego");
	
		
		System.out.println("Nom : " + sandiego.getNom());
		SeismeVue seismeVue = new SeismeVue();
		SeismeVue.launch(SeismeVue.class, parametres);


		
	}

}
