package edu.century.finalproject.eurograph;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         City class for use in the project EuroRail for CSCI 2082 Century
 *         College
 * 
 *         The City class creates a city object which is used as nodes of a
 *         graph modeling a geographical area
 * 
 *         A city object is the lowest level in the class hierarchy and is used
 *         as a node for Station and is used as a component of a Destination
 * 
 *         The vertex numbers for cities starts at 0 and increases by one for
 *         each new city to make traversal between nodes easy
 */
public class City implements Cloneable {

	// Instance variables
	private static int countVertex = 0;// counts the number of City objects that
										// have been created.
	private int vertex; // a unique number for each City
	private String cityName; // the name of a city
	private String countryName;// he name of the country in which the city is
								// located

	/**
	 * Constructor for creating a city with null parameters
	 */
	public City() {
		cityName = null;
		countryName = null;
	}

	/**
	 * Constructor for a City object.
	 * 
	 * @param city
	 *            the name of the city
	 * @param country
	 *            the name of the country in which the city is located.
	 * @precondition city and country contain Strings
	 * @postcondition An object of Class city is created.
	 */
	public City(String city, String country) {

		// Assign a unique vertex number
		vertex = countVertex++;

		cityName = city;
		countryName = country;
	}

	/**
	 * A constructor that creates a copy of a City
	 * 
	 * @param other
	 *            a City object to be copied
	 * @precondition other is a City object
	 * @postconditin a City object is created
	 */
	public City(City other) {

		this.vertex = other.vertex;
		this.cityName = other.cityName;
		this.countryName = other.countryName;
	}

	/**
	 * toString Returns a string representation of the city
	 * 
	 * @return a String that contains the instance variables of a City object
	 */
	@Override
	public String toString() {
		return "\nVertex: " + vertex + ", City: " + cityName + ", Country: " + countryName;
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param city
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object city) {
		boolean isEqual = false;

		if (city != null && (city instanceof City)) {

			// Cast the passed object to City
			City castCity = (City) city;

			// Evaluate to determine equivalence
			if (getVertex() == castCity.getVertex()
					&& this.cityName.toLowerCase().equals(castCity.cityName.toLowerCase())
					&& this.countryName.toLowerCase().equals(castCity.countryName.toLowerCase())) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	/**
	 * a Clone method for the City class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public City clone() {
		try {
			City copy = (City) super.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * Gets countVertex
	 * 
	 * @return the countVertex
	 */
	public static int getCountVertex() {
		return countVertex;
	}

	/**
	 * sets countVertex
	 * 
	 * @param countVertex
	 *            the countVertex to set
	 */
	public static void setCountVertex(int countVertex) {
		City.countVertex = countVertex;
	}

	/**
	 * gets the vertex value for a City
	 * 
	 * @return the int value stored in variable vertex
	 */
	public int getVertex() {
		return vertex;
	}

	/**
	 * Sets the vertex value
	 * 
	 * @param vertex
	 *            the vertex to set
	 */
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	/**
	 * gets the cityName of a City
	 * 
	 * @return a reference to the value stored in the variable cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * Sets the name of the city
	 * 
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * gets the countryName of a City object
	 * 
	 * @return a reference to the value stored in the variable countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Sets the country name
	 * 
	 * @param countryName
	 *            the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
