
package edu.century.finalproject.eurograph.collections;

import edu.century.finalproject.eurograph.City;
import edu.century.finalproject.eurograph.Station;
import edu.century.finalproject.eurograph.exceptions.StationNotFoundException;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         EuropeMap class for use in the project EuroRail for CSCI 2082 Century
 *         College
 * 
 *         EuropeMap contains the components of a map of Europe as well as the
 *         methods to create the graph representation
 * 
 *         EuropeMap is called by GraphOperator class to create the graph
 */

public class EuropeMap {

	// Instance variables
	// The collection the graph is going to be stored in
	protected static StationCollection europe = new StationCollection();

	// Instance variables for all the cities in the map
	// Portugal
	private final static City LISBON = new City("Lisbon", "Portugal");
	private final static City PORTO = new City("Porto", "Portugal");
	private final static City FARO = new City("Faro", "Portugal");

	// Spain
	private final static City MADRID = new City("Madrid", "Spain");
	private final static City SEVILLA = new City("Sevilla", "Spain");
	private final static City MALAGA = new City("Malaga", "Spain");
	private final static City VALENCIA = new City("Valencia", "Spain");
	private final static City PAMPLONA = new City("Pamplona", "Spain");
	private final static City BARCELONA = new City("Barcelona", "Spain");
	private final static City SANTIAGO = new City("Santiago", "Spain");
	private final static City SANTANDER = new City("Santander", "Spain");

	// France
	private final static City BORDEAUX = new City("Bordeaux", "France");
	private final static City MONTPELLIER = new City("Montpellier", "France");
	private final static City MARSEILLE = new City("Marseille", "France");
	private final static City NICE = new City("Nice", "France");
	private final static City LYON = new City("Lyon", "France");
	private final static City PARIS = new City("Paris", "France");
	private final static City RENNES = new City("Rennes", "France");

	// Switzerland
	private final static City BERN = new City("Bern", "Switzerland");

	// England
	private final static City LONDON = new City("London", "England");

	// Ireland
	private final static City WESTPORT = new City("Westport", "Ireland");
	private final static City CORK = new City("Cork", "Ireland");
	private final static City DUBLIN = new City("Dublin", "Ireland");
	private final static City BELFAST = new City("Belfast", "Ireland");

	// Belgium
	private final static City BRUSSELS = new City("Brussels", "Belgium");

	// Netherlands
	private final static City AMSTERDAM = new City("Amsterdam", "Netherlands");

	// Italy
	private final static City MILAN = new City("Milan", "Italy");
	private final static City VENICE = new City("Venice", "Italy");
	private final static City BOLOGNA = new City("Bologna", "Italy");
	private final static City FLORENCE = new City("Florence", "Italy");
	private final static City ROME = new City("Rome", "Italy");
	private final static City NAPLES = new City("Naples", "Italy");
	private final static City BARI = new City("Bari", "Italy");
	private final static City CALABRIA = new City("Calabria", "Italy");

	// Germany
	private final static City COLOGNE = new City("Cologne", "Germany");
	private final static City FRANKFURT = new City("Frankfurt", "Germany");
	private final static City MUNICH = new City("Munich", "Germany");
	private final static City BERLIN = new City("Berlin", "Germany");
	private final static City HAMBURG = new City("Hamburg", "Germany");

	// Czech Republic
	private final static City PRAGUE = new City("Prague", "Czech Republic");

	// Austria
	private final static City VIENNA = new City("Vienna", "Austria");

	// Poland
	private final static City WARSAW = new City("Warsaw", "Poland");

	// Slovenia
	private final static City LJUBLJANA = new City("Ljubljana", "Slovenia");

	// Croatia
	private final static City ZAGREB = new City("Zagreb", "Croatia");

	// Hungary
	private final static City BUDAPEST = new City("Budapest", "Hungary");

	// Bosnia Herzogovina
	private final static City SARAJEVO = new City("Sarajevo", "Bosnia Herzogovina");

	// Serbia
	private final static City BELGRADE = new City("Belgrade", "Serbia");

	// Macedonia
	private final static City SKOPJE = new City("Skopje", "Macedonia");

	// Romania
	private final static City BUCHAREST = new City("Bucharest", "Romania");

	// Bulgaria
	private final static City SOFIA = new City("Sofia", "Bulgaria");

	// Turkey
	private final static City ISTANBUL = new City("Istanbul", "Turkey");

	// Greece
	private final static City THESSALONIKI = new City("Thessaloniki", "Greece");
	private final static City ATHENS = new City("Athens", "Greece");

	// Denmark
	private final static City COPENHAGEN = new City("Copenhagen", "Denmark");

	// Norway
	private final static City OSLO = new City("Oslo", "Norway");
	private final static City BERGEN = new City("Bergen", "Norway");
	private final static City TRONDHEIM = new City("Trondheim", "Norway");

	// Sweden
	private final static City STOCKHOLM = new City("Stockholm", "Sweden");
	private final static City OSTERSUND = new City("Ostersund", "Sweden");
	private final static City KIRUNA = new City("Kiruna", "Sweden");

	/**
	 * StationCollection adds all of the destinations of cities to the cities as
	 * well as the destinations distance and adds the cities to the
	 * StationCollection
	 * 
	 * @return returns the StationCollection containing the graph of Europe
	 */
	public static StationCollection fillStations() {
		// Portugal
		Station lisbon = new Station(LISBON);
		lisbon.addDestination(PORTO, 3);
		lisbon.addDestination(FARO, 4);
		lisbon.addDestination(MADRID, 10);

		Station porto = new Station(PORTO);
		porto.addDestination(LISBON, 3);

		Station faro = new Station(FARO);
		faro.addDestination(LISBON, 4);

		europe.add(lisbon);
		europe.add(porto);
		europe.add(faro);

		// Spain
		Station madrid = new Station(MADRID);
		madrid.addDestination(LISBON, 10);
		madrid.addDestination(SEVILLA, 3);
		madrid.addDestination(MALAGA, 3);
		madrid.addDestination(SANTIAGO, 7);
		madrid.addDestination(SANTANDER, 5);
		madrid.addDestination(VALENCIA, 4);
		madrid.addDestination(BARCELONA, 3);
		madrid.addDestination(PAMPLONA, 3);
		madrid.addDestination(BORDEAUX, 11);

		Station sevilla = new Station(SEVILLA);
		sevilla.addDestination(MADRID, 3);
		sevilla.addDestination(BARCELONA, 6);

		Station malaga = new Station(MALAGA);
		malaga.addDestination(MADRID, 3);

		Station santiago = new Station(SANTIAGO);
		santiago.addDestination(MADRID, 7);

		Station santander = new Station(SANTANDER);
		santander.addDestination(MADRID, 5);

		Station valencia = new Station(VALENCIA);
		valencia.addDestination(MADRID, 4);
		valencia.addDestination(BARCELONA, 3);

		Station barcelona = new Station(BARCELONA);
		barcelona.addDestination(SEVILLA, 6);
		barcelona.addDestination(MADRID, 3);
		barcelona.addDestination(MONTPELLIER, 5);

		Station pamplona = new Station(PAMPLONA);
		pamplona.addDestination(MADRID, 3);

		europe.add(madrid);
		europe.add(sevilla);
		europe.add(malaga);
		europe.add(santiago);
		europe.add(santander);
		europe.add(valencia);
		europe.add(barcelona);
		europe.add(pamplona);

		// France
		Station bordeaux = new Station(BORDEAUX);
		bordeaux.addDestination(MADRID, 11);
		bordeaux.addDestination(PARIS, 3);
		bordeaux.addDestination(LYON, 6);

		Station montpellier = new Station(MONTPELLIER);
		montpellier.addDestination(BARCELONA, 5);
		montpellier.addDestination(MARSEILLE, 2);

		Station marseille = new Station(MARSEILLE);
		marseille.addDestination(MONTPELLIER, 2);
		marseille.addDestination(NICE, 3);
		marseille.addDestination(LYON, 4);

		Station nice = new Station(NICE);
		nice.addDestination(MARSEILLE, 3);
		nice.addDestination(MILAN, 4);

		Station lyon = new Station(LYON);
		lyon.addDestination(MARSEILLE, 4);
		lyon.addDestination(BORDEAUX, 6);
		lyon.addDestination(PARIS, 2);
		lyon.addDestination(BERN, 4);

		Station paris = new Station(PARIS);
		paris.addDestination(BORDEAUX, 3);
		paris.addDestination(RENNES, 2);
		paris.addDestination(BRUSSELS, 1);
		paris.addDestination(LONDON, 2);
		paris.addDestination(FRANKFURT, 4);
		paris.addDestination(LYON, 2);

		Station rennes = new Station(RENNES);
		rennes.addDestination(PARIS, 2);

		europe.add(bordeaux);
		europe.add(montpellier);
		europe.add(marseille);
		europe.add(nice);
		europe.add(lyon);
		europe.add(paris);
		europe.add(rennes);

		// Switzerland
		Station bern = new Station(BERN);
		bern.addDestination(LYON, 4);
		bern.addDestination(FRANKFURT, 4);
		bern.addDestination(MILAN, 5);

		europe.add(bern);

		// England
		Station london = new Station(LONDON);
		london.addDestination(PARIS, 2);
		london.addDestination(BRUSSELS, 2);

		europe.add(london);

		// Ireland
		Station dublin = new Station(DUBLIN);
		dublin.addDestination(CORK, 3);
		dublin.addDestination(WESTPORT, 4);
		dublin.addDestination(BELFAST, 4);

		Station westport = new Station(WESTPORT);
		westport.addDestination(DUBLIN, 4);

		Station cork = new Station(CORK);
		cork.addDestination(DUBLIN, 3);

		Station belfast = new Station(BELFAST);
		belfast.addDestination(DUBLIN, 4);

		europe.add(dublin);
		europe.add(westport);
		europe.add(cork);
		europe.add(belfast);

		// Belgium
		Station brussels = new Station(BRUSSELS);
		brussels.addDestination(PARIS, 1);
		brussels.addDestination(LONDON, 2);
		brussels.addDestination(COLOGNE, 2);
		brussels.addDestination(AMSTERDAM, 2);
		brussels.addDestination(FRANKFURT, 3);

		europe.add(brussels);

		// Netherlands
		Station amsterdam = new Station(AMSTERDAM);
		amsterdam.addDestination(BRUSSELS, 2);
		amsterdam.addDestination(COLOGNE, 3);
		amsterdam.addDestination(BERLIN, 7);
		amsterdam.addDestination(COPENHAGEN, 11);

		europe.add(amsterdam);

		// Italy
		Station milan = new Station(MILAN);
		milan.addDestination(NICE, 5);
		milan.addDestination(BERN, 5);
		milan.addDestination(MUNICH, 8);
		milan.addDestination(VENICE, 3);
		milan.addDestination(BOLOGNA, 1);

		Station venice = new Station(VENICE);
		venice.addDestination(MILAN, 3);
		venice.addDestination(MUNICH, 7);
		venice.addDestination(VIENNA, 7);
		venice.addDestination(LJUBLJANA, 2);
		venice.addDestination(FLORENCE, 2);

		Station bologna = new Station(BOLOGNA);
		bologna.addDestination(MILAN, 1);
		bologna.addDestination(FLORENCE, 1);

		Station florence = new Station(FLORENCE);
		florence.addDestination(BOLOGNA, 1);
		florence.addDestination(VENICE, 2);
		florence.addDestination(ROME, 4);

		Station rome = new Station(ROME);
		rome.addDestination(FLORENCE, 4);
		rome.addDestination(NAPLES, 2);
		rome.addDestination(BARI, 4);

		Station naples = new Station(NAPLES);
		naples.addDestination(ROME, 2);
		naples.addDestination(CALABRIA, 8);

		Station bari = new Station(BARI);
		bari.addDestination(ROME, 4);

		Station calabria = new Station(CALABRIA);
		calabria.addDestination(NAPLES, 8);

		europe.add(milan);
		europe.add(venice);
		europe.add(bologna);
		europe.add(florence);
		europe.add(rome);
		europe.add(naples);
		europe.add(bari);
		europe.add(calabria);

		// Germany
		Station cologne = new Station(COLOGNE);
		cologne.addDestination(BRUSSELS, 2);
		cologne.addDestination(AMSTERDAM, 3);
		cologne.addDestination(BERLIN, 4);
		cologne.addDestination(FRANKFURT, 1);

		Station frankfurt = new Station(FRANKFURT);
		frankfurt.addDestination(PARIS, 4);
		frankfurt.addDestination(BRUSSELS, 3);
		frankfurt.addDestination(COLOGNE, 1);
		frankfurt.addDestination(HAMBURG, 6);
		frankfurt.addDestination(MUNICH, 3);
		frankfurt.addDestination(BERN, 4);

		Station munich = new Station(MUNICH);
		munich.addDestination(FRANKFURT, 3);
		munich.addDestination(HAMBURG, 6);
		munich.addDestination(BERLIN, 4);
		munich.addDestination(PRAGUE, 6);
		munich.addDestination(VIENNA, 4);
		munich.addDestination(VENICE, 7);
		munich.addDestination(MILAN, 8);

		Station berlin = new Station(BERLIN);
		berlin.addDestination(MUNICH, 4);
		berlin.addDestination(COLOGNE, 6);
		berlin.addDestination(HAMBURG, 2);
		berlin.addDestination(WARSAW, 6);
		berlin.addDestination(PRAGUE, 5);
		berlin.addDestination(FRANKFURT, 4);

		Station hamburg = new Station(HAMBURG);
		hamburg.addDestination(COPENHAGEN, 5);
		hamburg.addDestination(BERLIN, 2);
		hamburg.addDestination(MUNICH, 6);
		hamburg.addDestination(FRANKFURT, 4);

		europe.add(cologne);
		europe.add(frankfurt);
		europe.add(munich);
		europe.add(berlin);
		europe.add(hamburg);

		// Czech Republic
		Station prague = new Station(PRAGUE);
		prague.addDestination(BERLIN, 5);
		prague.addDestination(WARSAW, 7);
		prague.addDestination(VIENNA, 5);
		prague.addDestination(MUNICH, 6);

		europe.add(prague);

		// Austria
		Station vienna = new Station(VIENNA);
		vienna.addDestination(MUNICH, 5);
		vienna.addDestination(PRAGUE, 5);
		vienna.addDestination(WARSAW, 8);
		vienna.addDestination(BUDAPEST, 3);
		vienna.addDestination(VENICE, 7);

		europe.add(vienna);

		// Poland
		Station warsaw = new Station(WARSAW);
		warsaw.addDestination(BERLIN, 6);
		warsaw.addDestination(PRAGUE, 7);
		warsaw.addDestination(VIENNA, 8);
		warsaw.addDestination(BUDAPEST, 11);

		europe.add(warsaw);

		// Slovenia
		Station ljubljana = new Station(LJUBLJANA);
		ljubljana.addDestination(VIENNA, 2);
		ljubljana.addDestination(BUDAPEST, 9);
		ljubljana.addDestination(ZAGREB, 2);

		europe.add(ljubljana);

		// Croatia
		Station zagreb = new Station(ZAGREB);
		zagreb.addDestination(LJUBLJANA, 2);
		zagreb.addDestination(BUDAPEST, 6);
		zagreb.addDestination(BELGRADE, 6);
		zagreb.addDestination(SARAJEVO, 10);

		europe.add(zagreb);

		// Hungary
		Station budapest = new Station(BUDAPEST);
		budapest.addDestination(ZAGREB, 6);
		budapest.addDestination(LJUBLJANA, 9);
		budapest.addDestination(VIENNA, 3);
		budapest.addDestination(WARSAW, 11);
		budapest.addDestination(BUCHAREST, 14);
		budapest.addDestination(BELGRADE, 8);

		europe.add(budapest);

		// Bosnia Herzogovian
		Station sarajevo = new Station(SARAJEVO);
		sarajevo.addDestination(ZAGREB, 10);

		europe.add(sarajevo);

		// Serbia
		Station belgrade = new Station(BELGRADE);
		belgrade.addDestination(ZAGREB, 6);
		belgrade.addDestination(BUDAPEST, 8);
		belgrade.addDestination(BUCHAREST, 12);
		belgrade.addDestination(SOFIA, 8);
		belgrade.addDestination(SKOPJE, 9);

		europe.add(belgrade);

		// Macedonia
		Station skopje = new Station(SKOPJE);
		skopje.addDestination(BELGRADE, 9);
		skopje.addDestination(SOFIA, 10);
		skopje.addDestination(THESSALONIKI, 9);

		europe.add(skopje);

		// Romania
		Station bucharest = new Station(BUCHAREST);
		bucharest.addDestination(BUDAPEST, 14);
		bucharest.addDestination(BELGRADE, 12);
		bucharest.addDestination(SOFIA, 9);

		europe.add(bucharest);

		// Bulgaria
		Station sofia = new Station(SOFIA);
		sofia.addDestination(BELGRADE, 8);
		sofia.addDestination(BUCHAREST, 9);
		sofia.addDestination(ISTANBUL, 13);
		sofia.addDestination(SKOPJE, 10);
		sofia.addDestination(THESSALONIKI, 7);

		europe.add(sofia);

		// Turkey
		Station istanbul = new Station(ISTANBUL);
		istanbul.addDestination(SOFIA, 13);
		istanbul.addDestination(THESSALONIKI, 12);

		europe.add(istanbul);

		// Greece
		Station thessaloniki = new Station(THESSALONIKI);
		thessaloniki.addDestination(SKOPJE, 4);
		thessaloniki.addDestination(SOFIA, 7);
		thessaloniki.addDestination(ISTANBUL, 12);
		thessaloniki.addDestination(ATHENS, 5);

		Station athens = new Station(ATHENS);
		athens.addDestination(THESSALONIKI, 5);

		europe.add(thessaloniki);
		europe.add(athens);

		// Denmark
		Station copenhagen = new Station(COPENHAGEN);
		copenhagen.addDestination(HAMBURG, 5);
		copenhagen.addDestination(AMSTERDAM, 11);
		copenhagen.addDestination(OSLO, 9);
		copenhagen.addDestination(STOCKHOLM, 6);

		europe.add(copenhagen);

		// Norway
		Station oslo = new Station(OSLO);
		oslo.addDestination(STOCKHOLM, 6);
		oslo.addDestination(BERGEN, 7);
		oslo.addDestination(COPENHAGEN, 9);

		Station bergen = new Station(BERGEN);
		bergen.addDestination(OSLO, 7);

		europe.add(oslo);
		europe.add(bergen);

		// Sweden
		Station stockholm = new Station(STOCKHOLM);
		stockholm.addDestination(OSLO, 7);
		stockholm.addDestination(COPENHAGEN, 6);
		stockholm.addDestination(OSTERSUND, 7);
		stockholm.addDestination(KIRUNA, 16);

		Station ostersund = new Station(OSTERSUND);
		ostersund.addDestination(STOCKHOLM, 7);
		ostersund.addDestination(TRONDHEIM, 4);

		Station trondheim = new Station(TRONDHEIM);
		trondheim.addDestination(OSTERSUND, 4);

		Station kiruna = new Station(KIRUNA);
		kiruna.addDestination(STOCKHOLM, 16);

		europe.add(stockholm);
		europe.add(ostersund);
		europe.add(trondheim);
		europe.add(kiruna);
		return europe;
	}

	/**
	 * toString Returns a string representation of the graph
	 * 
	 * @return a String that contains the instance variables of a City object
	 */
	@Override
	public String toString() {

		int size = europe.getSize();

		String ret = "";

		try {
			for (int i = 0; i < size; i++) {
				ret += europe.search(i).toString();
			}
		} catch (StationNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	/**
	 * a Clone method for the StationCollection class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public EuropeMap clone() {

		EuropeMap answer;

		try {
			answer = (EuropeMap) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}

		return answer;
	}

	/**
	 * Get the graph of Europe
	 * 
	 * @return the europe
	 */
	public static StationCollection getEurope() {
		return europe;
	}

	/**
	 * Set the graph of Europe
	 * 
	 * @param europe
	 *            the europe to set
	 */
	public static void setEurope(StationCollection europe) {
		EuropeMap.europe = europe;
	}
}
