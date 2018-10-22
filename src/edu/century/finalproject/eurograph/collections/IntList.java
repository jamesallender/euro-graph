/**To change this license header,choose License Headers in Project/Properties.*To change this template file,choose Tools|Templates*and open the template in the editor.*/
package edu.century.finalproject.eurograph.collections;

import edu.century.finalproject.eurograph.IntNode;

/****
 * 
 * @author Matt Divertie, Dan Young, and James Allender
 *
 *         IntList class for use in the project EuroRail for CSCI 2082 Century
 *         College
 *
 *         IntList is a link list of IntNode node objects. IntList is used by
 *         Djikstra's algorithm to keep track of vertices
 */

public class IntList implements Cloneable {

	// Instance Variables
	private IntNode head; // The head of the list
	private IntNode tail; // The tail of the list
	private int numberOfNodes; // The number of nodes in the list

	/**
	 * Constructor creates a new empty list
	 */
	public IntList() {
		head = null;
		tail = null;
		numberOfNodes = 0;
	}

	/**
	 * Adds an node to the list
	 * 
	 * @param element
	 *            Element to be added
	 */
	public void add(int element) {

		if (head == null) {
			head = new IntNode(element, null);
			tail = head;
			numberOfNodes++;
		} else {
			IntNode temp = new IntNode(element, null);
			tail.setLink(temp);
			tail = tail.getLink();
			numberOfNodes++;
		}
	}

	/**
	 * Checks to see if the list is empty
	 * 
	 * @return whether or not the list has any nodes
	 */
	public boolean isEmpty() {
		return (numberOfNodes == 0);
	}

	/**
	 * Gets the number of nodes in the list
	 * 
	 * @return The number of nodes in the list
	 */
	public int manyNodes() {
		return numberOfNodes;
	}

	/**
	 * Checks to see if there is another node in the list after a given nodes
	 * 
	 * @param node
	 *            The node to check
	 * @return whether there are more nodes in the list
	 */
	public boolean hasNext(IntNode node) {
		return !node.equals(tail);
	}

	/**
	 * Checks to see if the given node is in the list
	 * 
	 * @param target
	 *            The node to check
	 * @return Whether the given node is in the list
	 */
	public boolean contains(int target) {

		IntNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			if (cursor.getData() == target)
				return true;
		}
		return false;
	}

	/**
	 * toString Returns a string representation of the IntList
	 * 
	 * @return a String that contains the instance variables of a IntList object
	 */
	@Override
	public String toString() {
		String ret = "";
		IntNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			ret += cursor.getData();
			ret += "\n\n";
		}
		return ret;
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param intlist
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object intlist) {
		boolean isEqual = false;

		if (intlist != null && (intlist instanceof IntList)) {

			// Cast the passed object to IntList
			IntList castIntList = (IntList) intlist;
			IntNode cursor1;
			IntNode cursor2;

			// Evaluate to determine equivalence
			for (cursor1 = this.getHead(), cursor2 = castIntList.getHead(); cursor1 != null; cursor1 = cursor1
					.getLink(), cursor2 = cursor2.getLink()) {
				if (!(cursor1.getData() == cursor2.getData()))
					return false;
			}
			return true;
		}
		return isEqual;
	}

	/**
	 * a Clone method for the City class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public IntList clone() {

		IntList answer;

		try {
			answer = (IntList) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}

		return answer;
	}

	/**
	 * Gets the head of the list
	 * 
	 * @return the head
	 */
	public IntNode getHead() {
		return head;
	}

	/**
	 * Sets the head of the list
	 * 
	 * @param head
	 *            the head to set
	 */
	public void setHead(IntNode head) {
		this.head = head;
	}

	/**
	 * Gets the tail of the list
	 * 
	 * @return the tail
	 */
	public IntNode getTail() {
		return tail;
	}

	/**
	 * Sets the tail of the list
	 * 
	 * @param tail
	 *            the tail to set
	 */
	public void setTail(IntNode tail) {
		this.tail = tail;
	}

	/**
	 * Gets the number of nodes in the list
	 * 
	 * @return the numberOfNodes
	 */
	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	/**
	 * Sets the number of nodes in the list
	 * 
	 * @param numberOfNodes
	 *            the numberOfNodes to set
	 */
	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}

}
