/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.century.finalproject.eurograph.collections;

import edu.century.finalproject.eurograph.*;
import edu.century.finalproject.eurograph.exceptions.*;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         DestinationCollection class for use in the project EuroRail for CSCI
 *         2082 Century College
 * 
 *         DestanationCollection is a linked list of destination nodes and is
 *         used by Station to hold the destinations corresponding to each
 *         station
 * 
 */
public class DestinationCollection implements Cloneable {

	// Instance variables
	private DestinationNode head;// the first node in the DestinationCollection
	private DestinationNode tail;// the last node in the DestinationCollection
	private int numberOfNodes;// the number of nodes currently in the
								// DestinationCollection

	/**
	 * Constructor that creates a empty list
	 * 
	 * @postcondition an object of Class DestinationCollection is created.
	 */
	public DestinationCollection() {
		head = null;
		tail = null;
		numberOfNodes = 0;
	}

	/**
	 * Adds a Destination object to the LinkedList DestinationCollection
	 * 
	 * @param element
	 *            a Destination that will be added to the front of
	 *            DestinationCollection.
	 * @precondition element is a Destination object.
	 * @postcondition DestinationNode containing the Destination element will be
	 *                added to the front of the DestinationCollection.
	 */
	public void add(Destination element) {

		if (head == null) {
			head = new DestinationNode(element, null);
			tail = head;
			numberOfNodes++;
		} else {
			DestinationNode tmp = new DestinationNode(element, head);
			head = tmp;
			numberOfNodes++;
		}
	}

	/**
	 * Checks if the DestinationCollection is empty.
	 * 
	 * @return a boolean, true if the DestinationCollection is empty, false if
	 *         it is not.
	 */
	public boolean isEmpty() {
		return (numberOfNodes == 0);
	}

	/**
	 * Gets a specified DestinationNode from a city name.
	 * 
	 * @param cityName
	 *            used to identify the DestinationNode that will be returned.
	 * @return a DestinationNode that has the cityName argument as its cityName
	 * @throws StationNotFoundException
	 */
	public DestinationNode getTargetNode(String cityName) throws StationNotFoundException {

		DestinationNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			String element = cursor.getData().getCityName();
			if (cityName.equals(element))
				return cursor;
		}
		throw new StationNotFoundException();
	}

	/**
	 * Gets a specified DestinationNode from a vertex number.
	 * 
	 * @param cityName
	 *            used to identify the DestinationNode that will be returned.
	 * @return a DestinationNode that has the cityName argument as its cityName
	 * @throws StationNotFoundException
	 */
	public DestinationNode getTargetNode(int vertex) throws StationNotFoundException {

		DestinationNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			int element = cursor.getData().getVertex();
			if (vertex == element)
				return cursor;
		}
		throw new StationNotFoundException();
	}

	/**
	 * Checks if the DestinationCollection contains a City with the cityName
	 * argument as its cityName variable.
	 * 
	 * @param cityName
	 * @return a boolean, true if there is a Destination with the cityName
	 *         variable of the cityName argument.
	 * @throws StationNotFoundException
	 */
	public boolean containsTarget(String cityName) throws StationNotFoundException {

		DestinationNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			String element = cursor.getCityName();
			if (cityName.equals(element))
				return true;
		}
		return false;
	}

	/**
	 * Checks if the DestinationCollection contains a Destination with argument
	 * cityName as its cityName variable
	 * 
	 * @param cityVertex
	 *            The method will search for a Destination with the vertexNumber
	 *            equal to cityVertex
	 * @return a boolean, true if the DestinationCollection contains a
	 *         Destination object with a vertexNumber of cityVertex, false if it
	 *         does not.
	 * @throws StationNotFoundException
	 */
	public boolean containsTarget(int cityVertex) throws StationNotFoundException {

		DestinationNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			int element = cursor.getData().getVertex();
			if (cityVertex == element)
				return true;
		}
		return false;
	}

	/**
	 * Removes the first DestinationNode from a DestinationCollection
	 * 
	 * @precondition the calling object is a non-empty DestinationCollection
	 * @postcondition the first node from the linked list DestinationCollection
	 *                has been removed.
	 * @throws EmptyListException
	 */
	public void removeFirst() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		if (head.getLink() == null) {
			head = null;
			tail = null;
			numberOfNodes--;
		} else {
			head = head.getLink();
			numberOfNodes--;
		}
	}

	/**
	 * Removes the last node from a DestinationCollection
	 * 
	 * @precondition the calling object is a non-empty DestinationCollection
	 * @postcondition the last node from the DestinationCollection has been
	 *                removed.
	 * @throws EmptyListException
	 */
	public void removeLast() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		if (head != null && head == tail) {
			head = null;
			tail = null;
			numberOfNodes--;
		} else {
			DestinationNode currentNode;
			DestinationNode nodeBefore;

			for (currentNode = head, nodeBefore = null; currentNode != null; nodeBefore = currentNode, currentNode = currentNode
					.getLink()) {
				if (currentNode == tail) {
					tail = nodeBefore;
					tail.setLink(null);
					numberOfNodes--;
				}
			}
		}
	}

	/**
	 * toString Returns a string representation of the DestinationCollection
	 * 
	 * @return a String that contains the instance variables of a
	 *         DestinationCollection object
	 */
	@Override
	public String toString() {
		String ret = "";
		DestinationNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			ret += cursor.getData().toString();
			ret += "\n\n";
		}
		return ret;
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param destCollection
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object destCollection) {
		boolean isEqual = false;

		if (destCollection != null && (destCollection instanceof DestinationCollection)) {

			// Cast the passed object to DestinationCollection
			DestinationCollection castDestCollection = (DestinationCollection) destCollection;
			DestinationNode cursor1;
			DestinationNode cursor2;

			// Evaluate to determine equivalence
			for (cursor1 = this.getHead(), cursor2 = castDestCollection.getHead(); cursor1 != null; cursor1 = cursor1
					.getLink(), cursor2 = cursor2.getLink()) {
				if (!cursor1.getData().equals(cursor2.getData()))
					return false;
			}
			return true;
		}
		return isEqual;
	}

	/**
	 * a Clone method for the DestinationCollection class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public DestinationCollection clone() {

		DestinationCollection answer;

		try {
			answer = (DestinationCollection) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}

		return answer;
	}

	/**
	 * Set the tail node
	 * 
	 * @param tail
	 *            the tail to set of a DestinationCollection
	 */
	public void setTail(DestinationNode tail) {
		this.tail = tail;
	}

	/**
	 * Gets the tail node
	 * 
	 * @return the tail node of a DestinationCollection
	 */
	public DestinationNode getTail() {
		return tail;
	}

	/**
	 * Set the head node
	 * 
	 * @param head
	 *            the head to set of a DestinationCollection
	 */
	public void setHead(DestinationNode head) {
		this.head = head;
	}

	/**
	 * Gets the head node
	 * 
	 * @return the head node of a DestinationCollection
	 */
	public DestinationNode getHead() {
		return head;
	}

	/**
	 * Gets the size of a Destination collection, i.e. the number of nodes in
	 * the DestinationCollection
	 * 
	 * @return the number of nodes in the DestinationCollection
	 */
	public int getSize() {
		return numberOfNodes;
	}

	/**
	 * Gets the number of nodes
	 * 
	 * @return the numberOfNodes
	 */
	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	/**
	 * Sets the number of nodes
	 * 
	 * @param numberOfNodes
	 *            the numberOfNodes to set
	 */
	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}

}
