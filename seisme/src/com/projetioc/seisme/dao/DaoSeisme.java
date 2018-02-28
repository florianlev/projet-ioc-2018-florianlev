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
	
	List<Seisme> listeSeismeMondial;
	List<Seisme> listeSeismeVille;
	
	public DaoSeisme()
	{
		listeSeismeMondial = new ArrayList<>();
		listeSeismeVille = new ArrayList<>();
	}
	
	
	
	public List<Seisme> getRechercherVilleSeisme(String villeOnglet)
	{
		//listeSeisme = new ArrayList<>();
		
		String xmlRssSeismeVille = "";
		URL urlRssSeismeVille;
		try 
		{
			
			villeOnglet = villeOnglet.replaceAll(" ", "%20");

			urlRssSeismeVille = new URL("https://soda.demo.socrata.com/resource/6yvf-kk3n.xml?$where=region%20like%20%27%25"+ villeOnglet +"%27&source=pr");
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
						Seisme seisme = new Seisme();
						Node noeudFruit = noeudsListeSeisme.item(position);
						
						//System.out.println(noeudFruit.getTextContent());
						Element elementSeisme = (Element)noeudFruit;

						//Recuper le nom
						Node noeudSeisme = elementSeisme.getElementsByTagName("region").item(0);// juste un nom a chercher dans le fruit
						Element elementNom = (Element)noeudSeisme;
						seisme.setNom(elementNom.getTextContent());
						
						
						// Récupérer le magnetisme
						Node noeudMagnitude = (Element)elementSeisme.getElementsByTagName("magnitude").item(0);
						Element elementMagnitude = (Element)noeudMagnitude;
						seisme.setMagnitude(elementMagnitude.getTextContent());
				
						Node noeudLocation = (Element)elementSeisme.getElementsByTagName("location").item(0);
						Element elementLocation = (Element)noeudLocation;
						seisme.setLocalisation(elementLocation.getTextContent());
						
						Node noeudNombreStation = (Element)elementSeisme.getElementsByTagName("number_of_stations").item(0);
						Element elementNombreStation = (Element)noeudNombreStation;
						seisme.setNombreStations(elementNombreStation.getTextContent());
						
						listeSeismeVille.add(seisme);
						
						
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
		return listeSeismeVille;

		//System.out.println(xmlRssSeismeVille);
		
	}
	
	public List<Seisme> getRechercherMondialSeisme()
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
						
						
						listeSeismeMondial.add(seisme);
						
						
						
					
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
		
		return  listeSeismeMondial;
		//System.out.println(xmlRssSeismeVille);
		
	}
	
	/*public List<Seisme> getListeSeisme()
	{
		rechercherMondialSeisme();
		return listeSeisme;
	}*/
	
	
	
	
}
