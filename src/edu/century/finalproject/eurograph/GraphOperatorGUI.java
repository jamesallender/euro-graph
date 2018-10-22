package edu.century.finalproject.eurograph;

import java.awt.BorderLayout;
import java.net.URL;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import edu.century.finalproject.eurograph.exceptions.EmptyListException;
import edu.century.finalproject.eurograph.exceptions.StationNotConnectedException;
import edu.century.finalproject.eurograph.exceptions.StationNotFoundException;
import java.awt.Image;

/**
 *
 * @author Matt Divertie, Dan Young, and James Allender
 * 
 *         GraphOperatorGUI class for use in the project EuroRail for CSCI 2082
 *         Century College
 * 
 *         GraphOperatorGUI is a class that constructs a GUI to use the
 *         functionality of the EuroGraph project. Mainly to demonstrate
 *         dijkstra's algorithm being used on a graph
 */

@SuppressWarnings("serial")
public class GraphOperatorGUI extends JFrame implements ActionListener {

	// Instance Variables
	private GraphOperator graph = new GraphOperator(); // Creates Graph
	private String[] cities; // An array of the cities as strings
	private String[] selectionCities; // An array of the cities as strings
										// formated for the drop down
	private String selection1; // Drop down selection
	private String selection2; // Drop down selection

	// Image / image handling variables
	private String imagePath = "/edu/century/finalproject/eurograph/resources/";
	private String imageName = "EuroMap.png";
	private String imageLocation = imagePath + imageName;
	private URL url = GraphOperatorGUI.class.getResource(imageLocation);
	private ImageIcon map = new ImageIcon(url);
	private JLabel mapIcon = new JLabel(map);

	// GUI dimensions
	private final static int WIDTH = 643; // Image with = 643
	private final static int HEIGHT = 700; // 700

	// ComboBoxs (Drop downs)
	private JComboBox<Object> citiesList1;
	private JComboBox<Object> citiesList2;

	// Buttons
	private JButton searchBtn = new JButton("Search");

	// Boarders
	private TitledBorder searchTitle = new TitledBorder("Search");

	// Menu and menu items
	private JMenuBar menubar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem helpMnuItm = new JMenuItem("Help");
	private JMenuItem clearMnuItm = new JMenuItem("Clear");
	private JMenu advancedMenu = new JMenu("Advanced");
	private JMenuItem advancedMnuItm = new JMenuItem("Advanced Version");

	// Text areas and scroll areas
	private JTextArea output = new JTextArea(10, 2);
	private JScrollPane scroll = new JScrollPane(output);

	// Labels
	private JLabel citiesBox1Lbl = new JLabel("From");
	private JLabel citiesBox2Lbl = new JLabel("To");

	// Panels
	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel midPanel = new JPanel(new GridLayout(3, 2));
	private JPanel bottomPanel = new JPanel(new BorderLayout());

	/**
	 * Constructor for creating a new GUI
	 */
	public GraphOperatorGUI() {
		// Set the properties of the GUI object
		setSize(WIDTH, HEIGHT);
		setTitle("Euro Graph Traversal Using Dijkstra's Algorithm");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		// Method calls for creating GUI components
		createComboBox();
		addActionListeners();
		menuCreator();

		// Method calls for creating and formating the GUI's panels
		topPanelCreator();
		midPanelCreator();
		bottomPaneslCreator();

		// Configure menu bar
		setJMenuBar(menubar);

		// Add components to the frame
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * createComboBox() Creates the lists for use in the drop down boxes
	 */
	private void createComboBox() {
		// Gets all of the city and country names as an array of Strings
		cities = graph.getCitiesStringArr();

		// Creates a new array containing cities where the first option is
		// 'Select:'
		selectionCities = new String[cities.length + 1];
		System.arraycopy(cities, 0, selectionCities, 1, cities.length);
		selectionCities[0] = "Select:";

		// Creates the comboBox drop down boxes using the array of city and
		// country names
		citiesList1 = new JComboBox<Object>(selectionCities);
		citiesList2 = new JComboBox<Object>(selectionCities);

		// Sets the initial index of the drop downs
		citiesList1.setSelectedIndex(0);
		citiesList2.setSelectedIndex(0);

	}

	/**
	 * addActionListeners() adds action listeners to the relevant components of
	 * the GUI
	 */
	public void addActionListeners() {
		citiesList1.addActionListener(this);
		citiesList2.addActionListener(this);
		searchBtn.addActionListener(this);
		clearMnuItm.addActionListener(this);
		advancedMnuItm.addActionListener(this);
		helpMnuItm.addActionListener(this);
	}

	/**
	 * menuCreator() adds the menu components to the programs menu
	 */
	public void menuCreator() {
		fileMenu.add(helpMnuItm);
		fileMenu.add(clearMnuItm);
		menubar.add(fileMenu);
		advancedMenu.add(advancedMnuItm);
		menubar.add(advancedMenu);
	}

	/**
	 * topPanelCreator() adds components to the top panel and sets their border
	 * and properties
	 */
	public void topPanelCreator() {
            
                map = scaleImage(map, WIDTH, 300);
                mapIcon = new JLabel(map);
		topPanel.add(mapIcon, BorderLayout.CENTER);
	}
        
        public ImageIcon scaleImage(ImageIcon icon, int w, int h){
            
            int nw = icon.getIconWidth();
            int nh = icon.getIconHeight();
            
            if(icon.getIconWidth() > w){
                
                nw = w;
                nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
            }
            
            if(nh > h){
                
                nh = h;
                nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
            }
            
            return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
        }

	/**
	 * midPanelCreator() adds components to the top panel and sets their border
	 * and properties
	 */
	public void midPanelCreator() {
		midPanel.setBorder(searchTitle);
		midPanel.add(citiesList1);
		midPanel.add(citiesBox1Lbl);
		midPanel.add(citiesList2);
		midPanel.add(citiesBox2Lbl);
		midPanel.add(searchBtn);
	}

	/**
	 * bottomPaneslCreator() adds components to the top panel and sets their
	 * border and properties
	 */
	public void bottomPaneslCreator() {
		bottomPanel.setBorder(new TitledBorder(new EtchedBorder(), "Log"));
		bottomPanel.add(scroll);
	}

	/**
	 * actionPerformed overrides its super to add functionality to the GUI
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {

		// Try catch block to catch any exceptions thrown when running the
		// program as well as handle when cities are not connected
		try {
			// Handles the use of the first drop down menu
			if (e.getSource() == citiesList1) {
				JComboBox<Object> cb1 = (JComboBox<Object>) e.getSource();
				selection1 = (String) cb1.getSelectedItem();

				// Controls the label next to the drop down
				if (!selection1.equals("Select:")) {
					citiesBox1Lbl.setText("From: " + selection1);
				} else {
					citiesBox1Lbl.setText("From");
					selection1 = null;
				}
			}

			// Handles the use of the second drop down menu
			if (e.getSource() == citiesList2) {
				JComboBox<Object> cb2 = (JComboBox<Object>) e.getSource();
				selection2 = (String) cb2.getSelectedItem();

				// Controls the label next to the drop down
				if (!selection2.equals("Select:")) {
					citiesBox2Lbl.setText("To: " + selection2);
				} else {
					citiesBox2Lbl.setText("To");
					selection2 = null;
				}
			}

			// Handles when the search button is pushed
			if (e.getActionCommand() == "Search") {

				// If search is pushed but no selection has been made
				if (selection1 == null && selection2 == null) {
					output.setText("Please select a start and end location");

				}

				// If only one selection has been made from the drop downs
				else if (selection1 == null) {
					output.setText("Please select a start location");

				} else if (selection2 == null) {
					output.setText("Please select a end location");

				}

				// If two selections have been made and they are the same cities
				else if (selection1 == selection2) {
					output.setText(" You are trying to travel from '" + selection1 + "' to '" + selection2
							+ "'. The only time involved here \n is how long you sat on the train before you "
							+ "figured out you were already in "
							+ GraphOperator.guiSelectionInterpriterGiveCity(selection2)
							+ "...\n Take your gold star and get off the train.");
				}

				// If two separate cities have been selected
				// Note: this is for it either both cities are in Ireland and
				// different or are not in Ireland and different
				else {

					// Calls dijkstra's algorithm on the graph
					GraphOperator.dijkstra(graph, GraphOperator.guiSelectionInterpriter(selection1),
							GraphOperator.guiSelectionInterpriter(selection2));

					// Sets output
					output.setText(" Traveling From: '" + selection1 + "' -- To: --> '" + selection2 + "'\n" + "\n"
							+ "             ---------- Route Itinerary ----------" + "\n"
							+ GraphOperator.printItinerary() + "             ---------------------------------" + "\n"
							+ " Total travel time to " + selection2 + " from " + selection1 + " is "
							+ GraphOperator.getTripTime() + " hours " + "\n");
				}
			}

			// If clear has been selected from the drop down clears the GUI
			if (e.getActionCommand() == "Clear") {
				output.setText("");
				citiesBox1Lbl.setText("From");
				citiesBox2Lbl.setText("To");

			}

			// If advanced search has been selected from the menu
			// Note: Currently does nothing but inform user that functionality
			// is not yet available
			if (e.getActionCommand() == "Advanced Version") {
				output.append("\n Advanced Mode not yet ready");
			}

			// If help has been selected from the menu
			// Note: Currently only refers user to the JavaDoc
			if (e.getActionCommand() == "Help") {
				output.append("\n For help please see JavaDoc");
			}

		} catch (StationNotFoundException | StationNotConnectedException |

		EmptyListException e1)

		{
			// If the caught exception is 'StationNotConnectedException'
			// Informs user there is no train connection between the cites
			// Note: Only occurs when an Ireland city is selected for one option
			// and a non Ireland city has been selected for the other
			if (e1.getMessage().equals("Station not connected to destination")) {
				output.setText(" You are attempting to travel from '" + selection1 + "' to: '" + selection2 + "'\n"
						+ " There is no train route between these cities... Cuz Ocean...");
			}

			// Otherwise prints the exception to the console
			else {
				System.out.println(e1.getMessage());
			}
		}

	}

	/**
	 * Sets the text in the log
	 * 
	 * @param text
	 *            to be set
	 */
	public void setOutputText(String text) {
		output.setText(text);
	}

	/**
	 * Appends the text in the log
	 * 
	 * @param text
	 *            to be appended
	 */
	public void appendOutputText(String text) {
		output.append(text);
	}

	/**
	 * Gets the graph being used by the GUI
	 * 
	 * @return the graph
	 */
	public GraphOperator getGraph() {
		return graph;
	}

	/**
	 * Sets the graph being used by the GUI
	 * 
	 * @param graph
	 *            the graph being operated on
	 */
	public void setGraph(GraphOperator graph) {
		this.graph = graph;
	}

	/**
	 * Gets the width of the GUI
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * Gets the height of the GUI
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return HEIGHT;
	}

	/**
	 * Gets the path to the image
	 * 
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Sets the path to the image
	 * 
	 * @param imagePath
	 *            the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * Gets the name of the image
	 * 
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * Sets the name of the image
	 * 
	 * @param imageName
	 *            the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * Gets the image location
	 * 
	 * @return the imageLocation
	 */
	public String getImageLocation() {
		return imageLocation;
	}

	/**
	 * Sets the image location
	 * 
	 * @param imageLocation
	 *            the imageLocation to set
	 */
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
}
