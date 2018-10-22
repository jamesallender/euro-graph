package edu.century.finalproject.eurograph.RUN;

import edu.century.finalproject.eurograph.GraphOperatorGUI;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         RunGUI class for use in the project EuroRail for CSCI 2082 Century
 *         College
 * 
 *         This is the main demo for the EuroGraph project to demonstrate its
 *         functionality
 * 
 *         ***RUN THIS FILE FOR FULL DEMONSTRATION***
 * 
 */

public class RunGUI {

	public static void main(String[] args) {
		// Sets Apple specific GUI properties for when the project is being run
		// on a mac
		if (System.getProperty("os.name").equals("Mac OS X")) {
			System.setProperty("apple.laf.useScreenMenuBar", "True");
		}

		// Create a new GUI and make it visible
		GraphOperatorGUI gui = new GraphOperatorGUI();
		gui.setVisible(true);

	}

}