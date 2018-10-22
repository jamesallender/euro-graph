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
 *         StationNotConnectedException class for use in the project EuroRail
 *         for CSCI 2082 Century College
 * 
 *         Exception for if a station is not connected
 */
@SuppressWarnings("serial")
public class StationNotConnectedException extends Exception {

	/**
	 * Exception for if a station is not connected
	 */
	public StationNotConnectedException() {
		super("Station not connected to destination");
	}

}
