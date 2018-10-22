/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.century.finalproject.eurograph.collections;

import java.util.ArrayList;

import edu.century.finalproject.eurograph.Station;
import edu.century.finalproject.eurograph.exceptions.*;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         StationCollection class for use in the project EuroRail for CSCI 2082
 *         Century College
 * 
 *         A StationCollection is an ArrayList of Station objects and is called
 *         by GraphOperator to model a map of Europe
 */
public class StationCollection {

	private ArrayList<Station> map; // an ArrayList that will contain
									// stations which will contain destinations
									// modeling Europe's train system

	/**
	 * Constructor for creating a StationCollection object
	 * 
	 * @postcondition an object of StationCollection is created.
	 */
	public StationCollection() {
		map = new ArrayList<Station>();
	}

	/**
	 * Adds a Station object to the ArrayList map.
	 * 
	 * @param s
	 *            a Station object
	 * @return true if the Station was successfully added to the variable map.
	 * @precondition s is a Station object.
	 * @postcondition the Station is added to the ArrayList map
	 */
	public boolean add(Station s) {
		return map.add(s);
	}

	/**
	 * Removes a Station from the ArrayList map
	 * 
	 * @param s
	 *            a Station object
	 * @return true if the Station object was successfully removed from the
	 *         variable map
	 * @precondition s is a Station object
	 * @postcondition s is removed from the ArrayList map
	 */
	public boolean remove(Station s) {
		return map.remove(s);
	}

	/**
	 * Determines if the arrayList variable map is empty
	 * 
	 * @return true if the ArrayList map is empty
	 */
	public boolean isEmpty() {
		map.trimToSize();
		int size = map.size();
		if (size == 0)
			return true;
		return false;

	}

	/**
	 * gets the size of the variable map
	 * 
	 * @return an int that is the size of the map ArrayList
	 */
	public int getSize() {
		map.trimToSize();

		return map.size();
	}

	/**
	 * gets the Station with vertexNumber of targetVertex
	 * 
	 * @param targetVertex
	 *            the vertexNumber of the Station you would like returned
	 * @return the Station object with the vertexNumber equal to targetVertex
	 * @throws StationNotFoundException
	 */
	public Station search(int targetVertex) throws StationNotFoundException {

		for (Station element : map) {
			if (element.getVertex() == targetVertex)
				return element;
		}

		throw new StationNotFoundException();
	}

	/**
	 * Gets the Station with the cityName of the cityName String argument
	 * 
	 * @param cityName
	 *            a String that is the name of a city in the mapGraph
	 * @return a Station with the same cityName as the cityName argument
	 * @throws StationNotFoundException
	 */
	public Station search(String cityName) throws StationNotFoundException {

		for (Station element : map) {
			if (element.getCityName().equals(cityName))
				return element;
		}

		throw new StationNotFoundException();
	}

	/**
	 * Gets the number of Destinations in a Station object
	 * 
	 * @param cityName
	 *            the cityName of the Station you want check the number of
	 *            Destinations
	 * @return an int, the number of destinations in the Station
	 * @throws StationNotFoundException
	 */
	public int manyDestinations(String cityName) throws StationNotFoundException {

		DestinationCollection list;

		for (Station element : map) {
			if (element.getCityName().equals(cityName)) {
				list = element.getDestinations();
				return list.getSize();
			}
		}

		throw new StationNotFoundException();
	}

	/**
	 * toString Returns a string representation of the StationCollection
	 * 
	 * @return a String that contains the instance variables of a
	 *         StationCollection object
	 */
	@Override
	public String toString() {
		return map.toString();
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param stationCollection
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object stationCollection) {
		boolean isEqual = false;

		if (stationCollection != null && (stationCollection instanceof StationCollection)) {

			// Cast the passed object to City
			StationCollection castStationCollection = (StationCollection) stationCollection;

			// Evaluate to determine equivalence
			if (map.equals(castStationCollection.map)) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	/**
	 * a Clone method for the StationCollection class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	@SuppressWarnings("unchecked")
	public StationCollection clone() {

		StationCollection answer;

		try {
			answer = (StationCollection) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}

		int size = this.getSize();

		for (int i = 0; i < size; i++) {
			answer.map = (ArrayList<Station>) this.map.clone();
		}

		return answer;
	}

	/**
	 * Get the map ArrayList
	 * 
	 * @return the map
	 */
	public ArrayList<Station> getMap() {
		return map;
	}

	/**
	 * Set the map ArrayList
	 * 
	 * @param map
	 *            the map to set
	 */
	public void setMap(ArrayList<Station> map) {
		this.map = map;
	}

}
