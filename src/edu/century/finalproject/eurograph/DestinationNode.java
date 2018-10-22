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
 *         DestinationNode class for use in the project EuroRail for CSCI 2082
 *         Century College
 * 
 *         A Destination node is a node for a DestinationCollection linked list,
 *         it contains an instance of Destination as its data
 */

public class DestinationNode implements Cloneable {

	// Instance Variables
	private Destination data;// a Destination object
	private DestinationNode link;// a reference to the next DestinationNode in a
									// linked list

	/**
	 * Constructor for a DestinationNode.
	 * 
	 * @param initialCity
	 *            a Destination the will become the data variable of the
	 *            DestinationNode
	 * @param initialLink
	 *            a DestinationNode that is a reference to the next node in the
	 *            ArrayList
	 * @precondition initialCity is a Destination object and initialLink is a
	 *               DestinationNode
	 * @postcondition a DestinationNode has been created.
	 */
	public DestinationNode(Destination initialCity, DestinationNode initialLink) {

		data = initialCity;
		link = initialLink;
	}

	/**
	 * Adds a DestinationNode after the DestinationNode calling object.
	 * 
	 * @param element
	 *            a Destination that will be placed in the data variable of the
	 *            DestinationNode added after the calling DestinationNode.
	 * @precondition element is a Destination object.
	 * @postcondition a DestinationNode has been added after the calling
	 *                DestinationNode object. The new DestinationNode has the
	 *                value of element as its data variable.
	 */
	public void addNodeAfter(Destination element) {
		link = new DestinationNode(element, link);
	}

	/**
	 * Searches the linked linked list for a given node starting at the head of
	 * the linked list
	 * 
	 * @param head
	 *            the head of a linked list
	 * @param targetName
	 *            the name of a city whose node you would like returned
	 * @return a Destination node that contains a City object with the cityName
	 *         of targetName
	 * @precondition head refers to the head of a linked list. targetName refers
	 *               to the name of one of the cities in the linked list.
	 * @postcondion a DestinationNode with a cityName equal to targetName is
	 *              returned
	 */
	public static DestinationNode listSearch(DestinationNode head, String targetName) {

		DestinationNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {

			Destination mark = cursor.getData();
			String tempName = mark.getCityName();

			if (tempName.equals(targetName))
				return cursor;
		}
		return null;
	}

	/**
	 * Removes the DestinationNode after the calling node object.
	 * 
	 * @precondition There is a node after the calling object.
	 * @postcondition The node after the calling node has been removed.
	 */
	public void removeNodeAfter() {
		link = link.link;
	}

	/**
	 * toString Returns a string representation of a DestinationNode
	 * 
	 * @return a String that contains the instance variables of a
	 *         DestinationNode object
	 */
	@Override
	public String toString() {

		String ret;
		ret = new String(this.getCityName());
		return ret;
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param destNode
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object destNode) {
		boolean isEqual = false;

		if (destNode != null && (destNode instanceof DestinationNode)) {

			// Cast the passed object to DestinationNode
			DestinationNode castDestNode = (DestinationNode) destNode;

			// Evaluate to determine equivalence
			if (castDestNode.getData().equals(castDestNode.getData())) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	/**
	 * a Clone method for the DestinationNode class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public DestinationNode clone() {

		try {
			DestinationNode copy = (DestinationNode) super.clone();
			copy.data = (Destination) data.clone();
			copy.link = null;

			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * Sets the data (city)
	 * 
	 * @param newDest
	 */
	public void setData(Destination newDest) {
		data = newDest;
	}

	/**
	 * Gets the data (city) in a DestinationNode object.
	 * 
	 * @return the Destination object in the DestinationNode's variable data.
	 */
	public Destination getData() {
		return data;
	}

	/**
	 * Sets the contained city's name
	 * 
	 * @param cityName
	 *            the new city name
	 */
	public void SetCityName(String cityName) {
		data.setCityName(cityName);
	}

	/**
	 * Gets the city's name from a DestinationNode
	 * 
	 * @return a String. The name of the city in the DestinationNode variable
	 *         data
	 */
	public String getCityName() {
		return data.getCityName();
	}

	/**
	 * Sets the link to the next node
	 * 
	 * @param newLink
	 */
	public void setLink(DestinationNode newLink) {
		link = newLink;
	}

	/**
	 * Gets the DestinationNode in the link variable of the calling object
	 * 
	 * @return The DestinationNode in the link variable
	 */
	public DestinationNode getLink() {
		return link;
	}
}
