package com.projetioc.seisme;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projetioc.seisme.action.ControleurSeisme;
import com.projetioc.seisme.dao.DaoSeisme;
import com.projetioc.seisme.modele.Ville;
import com.projetioc.seisme.vue.SeismeVue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.projetioc.seisme.action.ControleurSeisme;

public class SeismeApp {
	
	SeismeVue seismeVue;

	public static void main(String[] parametres) {
		// TODO Auto-generated method stub
		
	
		
		
		SeismeVue seismeVue = new SeismeVue();
		SeismeVue.launch(SeismeVue.class, parametres);


		
	}

}
