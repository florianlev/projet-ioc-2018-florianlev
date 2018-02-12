package com.projetioc.seisme.vue;
import java.util.List;

import com.projetioc.seisme.action.ControleurSeisme;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class SeismeVue extends Application {
	
	protected ControleurSeisme controleur;
	protected String texte;
	private int page;
	private List<String> liste;
	private Stage scenePrincipale;
	
	
	public SeismeVue()
	{
		this.controleur = new ControleurSeisme(this);
	}
	
	public void start(Stage scenePrincipale)
	{
		this.scenePrincipale = scenePrincipale;
		System.out.println(texte);	
		final Tab tab1 = new Tab(texte); 
		//tab1.setContent(rectangle); 
		//final Tab tab2 = new Tab("Onglet 2"); 
		TabPane tabPane = new TabPane(); 
		tabPane.getTabs().setAll(tab1);
		
		
		StackPane racine = new StackPane();

		racine.getChildren().add(tabPane);
		
		Scene scene = new Scene(racine, 300,250);

		scene.getStylesheets().add(SeismeVue.class.getResource("decoration/Seisme.css").toExternalForm());
		scenePrincipale.setScene(scene);
		scenePrincipale.show();
		
	}
	


	
	public void afficherMenu(String texte, int page)
	{	
		this.texte = texte;
		this.page = page;
		
		
		
	}
	
	public void afficherListe(List<String> liste, int page)
	{
		this.liste = liste;
		this.page = page;
		
	}
	
	public void afficherPagination(List<String> listeNumeros)
	{
		
	}
	
	
	
}


