/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.century.finalproject.eurograph;

import edu.century.finalproject.eurograph.collections.DestinationCollection;
import edu.century.finalproject.eurograph.exceptions.StationNotFoundException;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         Station class for use in the project EuroRail for CSCI 2082 Century
 *         College
 *
 *         The Station class contains a City object and is used as the elements
 *         of the ArrayList created by StationCollection and contains a
 *         DestinationCollection of destination nodes from the given city
 * 
 *         The City object refers to the city in which the Station is located.
 *         destinations refers to to the cities to which one can travel from the
 *         Station object.
 */
public class Station extends City implements Cloneable {

	// Instance variables
	private DestinationCollection destinations;// a LinkedList of Destination
												// objects

	/**
	 * A constructor for a Station object that takes a City object as its
	 * argument
	 * 
	 * @param city
	 *            a City object which will be made part of a Station object
	 * @postcondition a Station object is created with its place variable set to
	 *                the argument in the city parameter.
	 */
	public Station(City city) {
		super(city);
		destinations = new DestinationCollection();
	}

	/**
	 * Gets the Destination object associated with a given city name
	 * 
	 * @param name
	 *            The name of the city we want the destination for
	 * @return The destination with the associated name
	 * @throws StationNotFoundException
	 */
	public Destination getDestination(String name) throws StationNotFoundException {

		return destinations.getTargetNode(name).getData();
	}

	/**
	 * Gets the Destination object associated with a given city vertex number
	 * 
	 * @param name
	 *            The name of the city we want the destination for
	 * @return The destination with the associated vertex number
	 * @throws StationNotFoundException
	 */
	public Destination getDestination(int vertex) throws StationNotFoundException {

		return destinations.getTargetNode(vertex).getData();
	}

	/**
	 * Gets the destinations of a Station and returns them as an array
	 * 
	 * @return an array of Destination objects, each index refers to a
	 *         Destination of the Station object.
	 */
	public Destination[] getNeighbors() {

		Destination[] answer = new Destination[destinations.getSize()];

		int i;
		DestinationNode cursor;

		for (cursor = destinations.getHead(), i = 0; cursor != null; i++, cursor = cursor.getLink()) {
			answer[i] = cursor.getData();
		}

		return answer;
	}

	/**
	 * Gets the destinations of a Stations vertex numbers and returns them as an
	 * array
	 * 
	 * @return an array of vertex number corresponding to destinations, each
	 *         index refers to a Destination of the Station object.
	 */
	public int[] getNeighborsVert() {

		int[] answer = new int[destinations.getSize()];

		int i;
		DestinationNode cursor;

		for (cursor = destinations.getHead(), i = 0; cursor != null; i++, cursor = cursor.getLink()) {
			answer[i] = cursor.getData().getVertex();
		}

		return answer;
	}

	/**
	 * Gets the number of destinations a Station is connected to.
	 * 
	 * @return an int, the number of destinations in the Station object.
	 */
	public int manyNeighbors() {

		return destinations.getSize();
	}

	/**
	 * Adds a Destination to a Station object
	 * 
	 * @param input
	 *            a City object you wish to make a destination of the Station.
	 * @param timeTo
	 *            an int, the time in hours it takes to travel between the
	 *            Station and Destination
	 * @precondition input refers to a City object and timeTo is an int
	 * @postcondition a Destination object has been added to the variable
	 *                destinations in the Station object.
	 */
	public void addDestination(City input, int timeTo) {

		destinations.add(new Destination(input, timeTo));
	}

	/**
	 * Checks if the Station has a certain Destination
	 * 
	 * @param cityName
	 *            the name of a Destination. The method will check if there is a
	 *            Destination with this name in the Station variable
	 *            destinations.
	 * @return true if the Station has the Destination with the cityName of the
	 *         cityName parameter, false if it does not.
	 * @throws StationNotFoundException
	 */
	public boolean containsTarget(String cityName) throws StationNotFoundException {

		return destinations.containsTarget(cityName);

	}

	/**
	 * Checks if the Station has a certain Destination
	 * 
	 * @param cityVertex
	 *            the vertexNumber of a Destination. The method will check if
	 *            there is a Destination with this vertex in the Station
	 *            variable destinations.
	 * @return true if the Station has the Destination with the vertexNumber of
	 *         the cityVertex parameter, false if it does not.
	 * @throws StationNotFoundException
	 */
	public boolean containsTarget(int cityVertex) throws StationNotFoundException {
		return destinations.containsTarget(cityVertex);
	}

	/**
	 * toString Returns a string representation of the station
	 * 
	 * @return a String that contains the instance variables of a Station object
	 */
	@Override
	public String toString() {
		return super.toString() + "\nDestinations:\n\n" + destinations.toString();
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param station
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object station) {
		boolean isEqual = false;

		if (station != null && (station instanceof Station)) {

			// Cast the passed object to City
			Station castStation = (Station) station;

			// Evaluate to determine equivalence
			if (super.getCityName().equals(castStation.getCityName())
					&& super.getCountryName().equals(castStation.getCountryName())
					&& (super.getVertex() == castStation.getCityVertex())
					&& this.getDestinations().equals(castStation.getDestinations())) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	/**
	 * a Clone method for the Station class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public Station clone() {

		Station answer;
		answer = (Station) super.clone();
		answer.destinations = this.getDestinations();
		return answer;
	}

	/**
	 * Gets the city name of a Station object.
	 * 
	 * @return the String cityName of a Station object
	 */
	public String getCityName() {
		return super.getCityName();
	}

	/**
	 * Gets the country name of a Station object.
	 * 
	 * @return the String country Name of a Station object
	 */
	public String getCountryName() {
		return super.getCountryName();
	}

	/**
	 * Gets the city and country name of a Station object.
	 * 
	 * @return the String country and city Name of a Station object
	 */
	public String getCityAndCountry() {
		return super.getCityName() + ", " + super.getCountryName();
	}

	/**
	 * Gets the vertexNumber of the Station object
	 * 
	 * @return an int, the vertex id of the City in the Station object.
	 */
	public int getCityVertex() {
		return super.getVertex();
	}

	/**
	 * Gets the destinations of a Station object
	 * 
	 * @return a DestinationCollection, the variable destinations in the Station
	 *         object.
	 */
	public DestinationCollection getDestinations() {
		return destinations;
	}

	/**
	 * Sets the destinations of a Station object
	 * 
	 * @param destinations
	 *            the destinations to set
	 */
	public void setDestinations(DestinationCollection destinations) {
		this.destinations = destinations;
	}

}
