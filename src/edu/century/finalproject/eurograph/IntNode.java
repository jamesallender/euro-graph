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
 *         IntNode class for use in the project EuroRail for CSCI 2082 Century
 *         College
 * 
 *         IntNode creates a node for use in the link list created by IntList
 *         and IntStack and contains an int for data and a link to the next node
 */
public class IntNode implements Cloneable {

	// Instance variables
	private int data; // Data held by the node
	private IntNode link; // Link to the next node

	/**
	 * Constructor to create a new IntNode
	 * 
	 * @param nData
	 *            The data to be stored
	 * @param nLink
	 *            The link to the next node
	 */
	public IntNode(int nData, IntNode nLink) {

		data = nData;
		link = nLink;
	}

	/**
	 * toString Returns a string representation of the a IntNode
	 * 
	 * @return a String that contains the instance variables of a IntNode object
	 */
	@Override
	public String toString() {
		return "IntNode data: " + data + ", link: " + link;
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param node
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object node) {
		boolean isEqual = false;

		if (node != null && (node instanceof IntNode)) {

			// Cast the passed object to City
			IntNode castNode = (IntNode) node;

			// Evaluate to determine equivalence
			if (this.data == castNode.data && this.link.equals(castNode)) {
				isEqual = true;
			}
		}
		return isEqual;

	}

	/**
	 * a Clone method for the IntNode class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public Object clone() {

		try {
			IntNode copy = (IntNode) super.clone();
			copy.link = null;
			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * Sets data
	 * 
	 * @param data
	 *            the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Gets data
	 * 
	 * @return The nodes data
	 */
	public int getData() {
		return data;
	}

	/**
	 * Gets link
	 * 
	 * @return the nodes link
	 */
	public IntNode getLink() {

		return link;
	}

	/**
	 * Sets the nodes link
	 * 
	 * @param newLink
	 */
	public void setLink(IntNode newLink) {
		link = newLink;
	}
}
