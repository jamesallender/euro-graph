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
 *         StationNotFoundException class for use in the project EuroRail for
 *         CSCI 2082 Century College
 * 
 *         Exception for if a station is not found
 */
@SuppressWarnings("serial")
public class StationNotFoundException extends Exception {

	/**
	 * Exception for if a station is not found
	 */
	public StationNotFoundException() {

		super("Station not found.");
	}

}
