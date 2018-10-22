/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.century.finalproject.eurograph;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         Destination class for use in the project EuroRail for CSCI 2082
 *         Century College
 * 
 *         Destination Class creates a destination object that contains the city
 *         being traveled to and the time weight to get there
 * 
 *         A destination instance contains a City object as one of its
 *         parameters and is used as a component of a destination node
 * 
 *         Each Station has at least one Destination
 */
public class Destination extends City implements Cloneable {

	// Instance variables
	private int timeWeight; // Time to get to destination

	/**
	 * Constructor for the Destination Class
	 * 
	 * @param goToLocation
	 *            refers to the City that will be a Destination of a
	 *            corresponding Station
	 * @param timeTo
	 *            the amount of time between the Destination and its
	 *            corresponding Station.
	 * @postcondition a Destination object is created
	 */
	public Destination(City goToLocation, int timeTo) {
		// Makes a copy of the given city for this instance
		super(goToLocation);
		timeWeight = timeTo;
	}

	/**
	 * Returns a string representation of the destination
	 * 
	 * @return The cites instance variables as well as timeWeight
	 */
	@Override
	public String toString() {
		return "City:: " + super.toString() + "\nTrip Time: " + timeWeight + " hours";
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param dest
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object dest) {
		boolean isEqual = false;

		if (dest != null && (dest instanceof Destination)) {

			// Cast the passed object to City
			Destination castDest = (Destination) dest;

			// Evaluate to determine equivalence
			if (super.getCityName().toLowerCase().equals(castDest.getCityName().toLowerCase())
					&& super.getCountryName().toLowerCase().equals(castDest.getCountryName().toLowerCase())
					&& super.getVertex() == castDest.getVertex() && this.getTimeWeight() == castDest.getTimeWeight()) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	/**
	 * a Clone method for the Destination class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public Destination clone() {

		Destination copy = (Destination) super.clone();
		copy.timeWeight = this.timeWeight;
		return copy;
	}

	/**
	 * Gets the the cityName from a Destination object.
	 * 
	 * @return a String, the name of the city of the calling object
	 */
	public String getCityName() {
		return super.getCityName();
	}

	/**
	 * Gets the city vertex number from a Destination object
	 * 
	 * @return an int, the vertex number
	 */
	public int getCityVertex() {
		return super.getVertex();
	}

	/**
	 * Gets the amount of time between a Destination and its corresponding
	 * Station.
	 * 
	 * @return the amount of time it takes to travel between a Destination and
	 *         its corresponding Station.
	 */
	public int getTimeWeight() {
		return timeWeight;
	}

	/**
	 * Sets the amount of time it takes to travel between a Destination and its
	 * corresponding Station.
	 * 
	 * @param timeWeight
	 *            the new amount of time it will take to travel between a
	 *            Destination and its corresponding Station.
	 */
	public void setTimeWeight(int timeWeight) {

		this.timeWeight = timeWeight;
	}
}
