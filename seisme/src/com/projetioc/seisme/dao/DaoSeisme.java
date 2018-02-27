package com.projetioc.seisme.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.projetioc.seisme.modele.Seisme;

public class DaoSeisme<T> {
	
	List<Seisme> listeSeisme;
	
	public DaoSeisme()
	{
		listeSeisme = new ArrayList<>();
	}
	
	
	
	/*public List<String> rechercherVilleSeisme()
	{
		//listeSeisme = new ArrayList<>();
		String xmlRssSeismeVille = "";
		URL urlRssSeismeVille;
		try 
		{
			urlRssSeismeVille = new URL("https://soda.demo.socrata.com/resource/6yvf-kk3n.xml?source=nn");
			BufferedReader influx = new BufferedReader(new InputStreamReader(urlRssSeismeVille.openStream()));
			String ligne;
			while ((ligne = influx.readLine()) != null) xmlRssSeismeVille+=ligne;
			influx.close();	
			
			try {
				DocumentBuilder parseur =	DocumentBuilderFactory.newInstance().newDocumentBuilder();
				
				
				try {
					Document docListeSeisme = parseur.parse(new StringBufferInputStream (xmlRssSeismeVille));
					String racine = docListeSeisme.getDocumentElement().getNodeName();
					System.out.println("Racine:" + racine);
					NodeList noeudsListeSeisme = docListeSeisme.getElementsByTagName("row");
					for(int position = 0; position < noeudsListeSeisme.getLength(); position++)
					{
						Node noeudFruit = noeudsListeSeisme.item(position);
						
						//System.out.println(noeudFruit.getTextContent());
						Element elementSeisme = (Element)noeudFruit;

						//Recuper le nom
						Node noeudSeisme = elementSeisme.getElementsByTagName("depth").item(0);// juste un nom a chercher dans le fruit
						Element elementNom = (Element)noeudSeisme;
						String nom = elementNom.getTextContent();
						
						
						System.out.println("Nom : " + nom);
						
						// Récupérer la couleur
						Node elementRegion = (Element)elementSeisme.getElementsByTagName("region").item(0);
						String region = elementRegion.getTextContent();
				
						System.out.println("Couleur : " + region);
						
						//listeSeisme.add(region, nom);
						
						//Fruit fruit = new Fruit(nom, couleur);
						//listeFruits.put(fruit);
						
					}
				} catch (SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
		catch (MalformedURLException e) { e.printStackTrace();} 
		catch (IOException e) { e.printStackTrace(); }
		return listeSeisme;

		//System.out.println(xmlRssSeismeVille);
		
	}*/
	
	public void rechercherMondialSeisme()
	{
		String xmlRssSeismeMondial = "";
		URL urlRssSeismeMondial;
		try 
		{
			urlRssSeismeMondial = new URL("https://earthquake.usgs.gov/fdsnws/event/1/query?format=xml&starttime=2017-01-25&endtime=2017-01-30");
			BufferedReader influx = new BufferedReader(new InputStreamReader(urlRssSeismeMondial.openStream()));
			String ligne;
			while ((ligne = influx.readLine()) != null) xmlRssSeismeMondial+=ligne;
			influx.close();	
			
			try {
				DocumentBuilder parseur =	DocumentBuilderFactory.newInstance().newDocumentBuilder();
				
				
				try {
					Document docListeSeisme = parseur.parse(new StringBufferInputStream (xmlRssSeismeMondial));
					String racine = docListeSeisme.getDocumentElement().getNodeName();
					System.out.println("Racine:" + racine);
					NodeList noeudsListeSeisme = docListeSeisme.getElementsByTagName("event");
					for(int position = 0; position < noeudsListeSeisme.getLength(); position++)
					{
						
						Seisme seisme = new Seisme();
						Node noeudSeisme = noeudsListeSeisme.item(position);
						
						//System.out.println(noeudFruit.getTextContent());
						Element elementSeisme = (Element)noeudSeisme;

						//Recuper le nom
						Node noeudNom = elementSeisme.getElementsByTagName("description").item(0);
						Element elementNom = (Element)noeudNom;
						seisme.setNom(elementNom.getTextContent());
						
						
						//Latitude
						Node noeudLatitude = elementSeisme.getElementsByTagName("latitude").item(0);
						Element elementLatitude = (Element)noeudLatitude;
						seisme.setLatitude(elementLatitude.getTextContent());
						
						//Longitude
						
						Node noeudLongitude = elementSeisme.getElementsByTagName("longitude").item(0);
						Element elementLongitude = (Element)noeudLongitude;
						seisme.setLongitude(elementLongitude.getTextContent());
						
						//magnitude
						
						Node noeudMagnitude = elementSeisme.getElementsByTagName("longitude").item(0);
						Element elementMagnitude = (Element)noeudMagnitude;
						seisme.setMagnitude(elementMagnitude.getTextContent());
						
						
						listeSeisme.add(seisme);
						
						
						
					
					}
				} catch (SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
		catch (MalformedURLException e) { e.printStackTrace();} 
		catch (IOException e) { e.printStackTrace(); }
		

		//System.out.println(xmlRssSeismeVille);
		
	}
	
	public List<Seisme> getListeSeisme()
	{
		rechercherMondialSeisme();
		return listeSeisme;
	}
	
	
	
	
}
