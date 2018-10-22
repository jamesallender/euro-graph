/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.century.finalproject.eurograph.collections;

import java.util.EmptyStackException;

import edu.century.finalproject.eurograph.*;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         IntStack class for use in the project EuroRail for CSCI 2082 Century
 *         College
 * 
 *         IntStack is a stack implemented using a linked list that keeps track
 *         or the fastest path itinerary for Dijkstra's algorithm
 */

public class IntStack implements Cloneable {

	// Instance variables
	private IntNode top; // The top of the stack

	/**
	 * Constructor creates a new empty stack
	 */
	public IntStack() {
		top = null;
	}

	/**
	 * Checks to see if the stack is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (top == null);
	}

	/**
	 * Clears the stack
	 */
	public void clear() {
		top = null;
	}

	/**
	 * Gets the item at the top of the stack without popping it off
	 * 
	 * @return the top of the stack
	 */
	public int peek() {

		if (this.isEmpty())
			throw new EmptyStackException();
		return top.getData();
	}

	/**
	 * Get the item at the top of the Stack by popping it off
	 * 
	 * @return the top of the stack
	 */
	public int pop() {

		int answer;

		if (top == null)
			throw new EmptyStackException();

		answer = top.getData();
		top = top.getLink();
		return answer;
	}

	/**
	 * Pushes an item onto the top of the stack
	 * 
	 * @param item
	 *            to be pushed onto the stack
	 */
	public void push(int item) {
		top = new IntNode(item, top);
	}

	/**
	 * Gets the size of the stack
	 * 
	 * @return the size of the stack
	 */
	public int size() {
		int answer = 0;
		for (IntNode cursor = top; cursor != null; cursor = cursor.getLink()) {
			answer++;
		}
		return answer;
	}

	/**
	 * toString Returns a string representation of the IntStack
	 * 
	 * @return a String that contains the instance variables of a IntStack
	 *         object
	 */
	@Override
	public String toString() {
		String ret = "";
		IntNode cursor;

		for (cursor = top; cursor != null; cursor = cursor.getLink()) {
			ret += cursor.getData();
			ret += "\n\n";
		}
		return ret;
	}

	/**
	 * Checks if the calling object is equal to the argument object
	 * 
	 * @param intstack
	 *            an instance of the Object class
	 * @return true if the other Object is equal to the calling object, false if
	 *         it is not.
	 */
	@Override
	public boolean equals(Object intstack) {
		boolean isEqual = false;

		if (intstack != null && (intstack instanceof IntStack)) {

			// Cast the passed object to IntList
			IntStack castIntList = (IntStack) intstack;
			IntNode cursor1;
			IntNode cursor2;

			// Evaluate to determine equivalence
			for (cursor1 = this.getTop(), cursor2 = castIntList.getTop(); cursor1 != null; cursor1 = cursor1
					.getLink(), cursor2 = cursor2.getLink()) {
				if (!(cursor1.getData() == cursor2.getData()))
					return false;
			}
			return true;
		}
		return isEqual;
	}

	/**
	 * a Clone method for the IntStack class
	 * 
	 * @return a deep copy of the calling object
	 */
	@Override
	public Object clone() {

		IntStack answer;

		try {
			answer = (IntStack) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("This class does not" + "implement cloneable.");
		}

		IntNode cursor;

		for (cursor = top; cursor != null; cursor = cursor.getLink())
			answer.push(cursor.getData());

		return answer;
	}

	/**
	 * Get the top of the stack (does not pop)
	 * 
	 * @return the top
	 */
	public IntNode getTop() {
		return top;
	}

	/**
	 * Sets the top of the stack (does not push)
	 * 
	 * @param top
	 *            the top to set
	 */
	public void setTop(IntNode top) {
		this.top = top;
	}

}
