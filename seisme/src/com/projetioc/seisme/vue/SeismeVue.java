package com.projetioc.seisme.vue;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.projetioc.seisme.action.ControleurSeisme;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.collections.*;


public class SeismeVue<liste> extends Application {
	
	protected ControleurSeisme controleur;
	protected String texte;
	protected TabPane tabPane;
	protected Tab tab;
	private int page;
	//private List<String> liste = new ArrayList<String>();
	
	protected Tab ville1;
	protected Tab ville2;
	protected Tab ville3;
	protected Tab ville4;
	protected Tab ville5;
	protected Tab ville6;
	

	
	protected Text texte1;
	protected Text texte2;
	protected Text texte3;
	protected Text texte4;
	protected Text texte5;
	protected Text texte6;
	private List<String> liste;
	
	
	public SeismeVue()
	{
		this.controleur = new ControleurSeisme(this);
	}
	
	public void start(Stage scenePrincipale)
	{
		TabPane tabPane = new TabPane();
		ville1 = new Tab("");
		tabPane.getTabs().add(ville1);
		
		ville2 = new Tab("");
		tabPane.getTabs().add(ville2);
		
		ville3 = new Tab("");
		tabPane.getTabs().add(ville3);
		
		ville4 = new Tab("");
		tabPane.getTabs().add(ville4);
		
		ville5 = new Tab("");
		tabPane.getTabs().add(ville5);
		
		ville6 = new Tab("");
		tabPane.getTabs().add(ville6);

		Scene scene = new Scene(tabPane, 300,250);
		scenePrincipale.setScene(scene);
		scenePrincipale.show();
		

		//scene.getStylesheets().add(SeismeVue.class.getResource("decoration/Seisme.css").toExternalForm());
		
		controleur.afficherOnglets();
		
		
	}
	


	
	public void afficherMenu(String texte, int page)
	{	
		switch(page)
		{
		case 1:
			this.ville1.setText(texte);
			break;
		case 2:
			this.ville2.setText(texte);
			break;
		case 3:
			this.ville3.setText(texte);
			break;
		case 4:
			this.ville4.setText(texte);
			break;
		case 5:
			this.ville5.setText(texte);
			break;
		case 6:
			this.ville6.setText(texte);
			break;
		}
		
		
	}
	
	public void afficherListe(List<String> liste, int page)
	{
		//ListIterator<String> it = liste.listIterator();
		
		ObservableList items = FXCollections.observableArrayList(liste);

			for(int i = 0; i< liste.size(); i++)
			{
				switch(page)
				{
				case 1:
					//System.out.println("page" +page);

					
					ListView<String> listeview = new ListView<String>();
					listeview.setItems(items);
					ville1.setContent(listeview);
					
					break;
				case 2:
					System.out.println("page" +page);

					ListView<String> listeview2 = new ListView<String>();
					listeview2.setItems(items);
					ville2.setContent(listeview2);
					break;
				case 3:
					ListView<String> listeview3 = new ListView<String>();
					listeview3.setItems(items);
					ville3.setContent(listeview3);
					break;
				case 4:
					ListView<String> listeview4 = new ListView<String>();
					listeview4.setItems(items);
					ville4.setContent(listeview4);
					break;
				case 5:
					ListView<String> listeview5 = new ListView<String>();
					listeview5.setItems(items);
					ville5.setContent(listeview5);
					break;
				case 6:
					ListView<String> listeview6 = new ListView<String>();
					listeview6.setItems(items);
					ville6.setContent(listeview6);
					break;
				
			}
			}
			
		
		
	}
	
	public void afficherPagination(List<String> listeNumeros)
	{
		
	}
	
	
	
}


