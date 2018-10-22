package edu.century.finalproject.eurograph.RUN;

import edu.century.finalproject.eurograph.GraphOperator;
import edu.century.finalproject.eurograph.exceptions.EmptyListException;
import edu.century.finalproject.eurograph.exceptions.StationNotConnectedException;
import edu.century.finalproject.eurograph.exceptions.StationNotFoundException;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         GraphDemo class for use in the project EuroRail for CSCI 2082 Century
 *         College
 * 
 *         ****IMPORTANT**** This class runs a demonstration of the EuroGraph
 *         project and Dijksta's algorithm in the console, There is no
 *         implemented console IO and little in line commenting because the main
 *         IO Focus for this project it through the GUI
 * 
 *         **THIS IT NOT TO BE THE MAIN DEMO FOR THE PROJECT**
 */

public class RunConsoleDemo {
	public static void main(String[] args)
			throws StationNotFoundException, EmptyListException, StationNotConnectedException {
		try {
			int start = 1; // The start city referred to by vertex
			int dest = 15; // The destination city, referred to by vertex
			GraphOperator europe = new GraphOperator(); // The graph to be
														// operated on

			GraphOperator.dijkstra(europe, start, dest);
			System.out.println("Travle Time to " + europe.getVertexCityAndCountryName(dest) + " "
					+ GraphOperator.getTripTime() + " hours");
			System.out.println(GraphOperator.printItinerary());

			System.out.println("_______________________________________________");

			String[] cities;
			cities = europe.getCitiesStringArr();

			for (int i = 0; i < cities.length; i++) {
				System.out.println(cities[i]);
			}

			System.out.println("_______________________________________________");

			GraphOperator.dijkstra(europe,
					GraphOperator.guiSelectionInterpriter(europe.getVertexCityAndCountryName(start)),
					GraphOperator.guiSelectionInterpriter(europe.getVertexCityAndCountryName(dest)));

			System.out.println("Travle Time to " + europe.getVertexCityAndCountryName(dest) + " "
					+ GraphOperator.getTripTime() + " hours");
			System.out.println(GraphOperator.printItinerary());
			System.out.println("Total Trip time " + GraphOperator.getTripTime() + " hours " + "\n");
		} catch (StationNotFoundException | StationNotConnectedException | EmptyListException e) {
			System.out.println(e.getMessage());
		}
	}
}
