/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.century.finalproject.eurograph.exceptions;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         EmptyListException class for use in the project EuroRail for CSCI
 *         2082 Century College
 * 
 *         Exception for if a list is empty
 */
@SuppressWarnings("serial")
public class EmptyListException extends Exception {

	/**
	 * Exception for if a list is empty
	 */
	public EmptyListException() {
		super("List is empty");
	}
}
