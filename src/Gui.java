
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui {
	public static JButton EAST;
	public static JButton WEST;
	public static JButton CENTER;
	public static JButton NORTH;
	public static JButton SOUTH;

	public static void main(String[] args) {
		JFrame gui = new JFrame("My First GUI");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500, 500);
//		JButton button1 = new JButton("Books in");
//		JButton button2 = new JButton("Books Out");
//		frame.getContentPane().add(button1);
//		frame.getContentPane().add(button2);
		gui.setVisible(true);

		Container pane = gui.getContentPane();
//		pane.setBackground(new Color(12, 34, 50));
		pane.setLayout(new BorderLayout());

		JButton east = new JButton("East");
		JButton west = new JButton("West");
		JButton center = new JButton("Center");
		JButton north = new JButton("North");
		JButton south = new JButton("South");

		pane.add(east, BorderLayout.EAST);
		pane.add(west, BorderLayout.WEST);
		pane.add(center, BorderLayout.CENTER);
		pane.add(north, BorderLayout.NORTH);
		pane.add(south, BorderLayout.SOUTH);

	}

}
