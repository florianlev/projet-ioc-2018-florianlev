package com.projetioc.seisme.action;
import com.projetioc.seisme.vue.SeismeVue;

public class ControleurSeisme {
	
	protected SeismeVue vue;
	
	public ControleurSeisme(SeismeVue vue)
	{
		this.vue = vue;
	}
	
	public void direBonjour() {
		
		System.out.println("jeff");
		
	}

}
