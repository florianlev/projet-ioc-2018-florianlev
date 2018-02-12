package com.projetioc.seisme.vue;
import java.util.List;

import com.projetioc.seisme.action.ControleurSeisme;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class SeismeVue extends Application {
	
	protected ControleurSeisme controleur;

	public SeismeVue()
	{
		this.controleur = new ControleurSeisme(this);
	}
	
	public void afficherMenu(String texte, int page)
	{

		
	}
	
	public void afficherListe(List<String> liste, int page)
	{
		
	}
	
	public void afficherPagination(int listeNumeros)
	{
		
	}
	

	
	public void start(Stage scenePrincipale)
	{
		final Tab tab1 = new Tab("lala"); 
		//tab1.setContent(rectangle); 
		final Tab tab2 = new Tab("Onglet 2"); 
		TabPane tabPane = new TabPane(); 
		tabPane.getTabs().setAll(tab1, tab2);
		
		
		StackPane racine = new StackPane();
		//racine.getChildren().add(this.actionDireBonjour);
		//racine.getChildren().add(actionDireBonjour);
		//scenePrincipale.setScene(new Scene(racine, 300, 250));
		racine.getChildren().add(tabPane);
		
		Scene scene = new Scene(racine, 300,250);

		scene.getStylesheets().add(SeismeVue.class.getResource("decoration/Seisme.css").toExternalForm());
		scenePrincipale.setScene(scene);
		scenePrincipale.show();
		
	}
}


