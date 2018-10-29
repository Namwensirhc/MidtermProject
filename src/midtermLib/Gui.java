package midtermLib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton EAST;
	private JButton WEST;
	private JButton CENTER;
	private JButton NORTH;
	private JButton SOUTH;

	private void createAndShowGUI() {
		JFrame gui;
		Container pane;

		gui = new JFrame("My First GUI");
		gui.setTitle("Welcome to my first GUI.");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500, 500);
		gui.setVisible(true);

		EAST = new JButton("EAST");
		EAST.addActionListener(this);
		WEST = new JButton("WEST");
		WEST.addActionListener(this);
		CENTER = new JButton("CENTER");
		CENTER.addActionListener(this);
		NORTH = new JButton("NORTH");
		NORTH.addActionListener(this);
		SOUTH = new JButton("SOUTH");
		SOUTH.addActionListener(this);

		pane = gui.getContentPane();
		pane.setBackground(new Color(153, 34, 255));
		pane.setLayout(new BorderLayout());

		pane.add(EAST, BorderLayout.EAST);
		pane.add(WEST, BorderLayout.WEST);
		pane.add(CENTER, BorderLayout.CENTER);
		pane.add(NORTH, BorderLayout.NORTH);
		pane.add(SOUTH, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gui gui = new Gui();
				gui.createAndShowGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Declare and initialize variables.

		// Get source of event (5 buttons in GUI)
		JButton sourceEvent = (JButton) event.getSource();

		if (sourceEvent == EAST) {
			// doEasterlyStuff();
		} else if (sourceEvent == WEST) {
			// doWesterlyStuff();
		} else if (sourceEvent == CENTER) {
			// doCentralStuff();
		} else if (sourceEvent == NORTH) {
			// doNortherlyStuff();
		} else if (sourceEvent == SOUTH) {
			// doSoutherlyStuff();
		}

	}

}
