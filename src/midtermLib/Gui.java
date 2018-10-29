package midtermLib;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

        gui = new JFrame(â€œMy First GUIâ€?);
        gui.setTitle(â€œWelcome to my first GUI.â€œ);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(500, 500);
        gui.setVisible(true);

        EAST = new JButton(â€œEASTâ€?);
        EAST.addActionListener(this);
        WEST = new JButton(â€œWESTâ€?);
        WEST.addActionListener(this);
        CENTER = new JButton(â€œCENTERâ€?);
        CENTER.addActionListener(this);
        NORTH = new JButton(â€œNORTHâ€?);
        NORTH.addActionListener(this);
        SOUTH = new JButton(â€œSOUTHâ€?);
        SOUTH.addActionListener(this);

        pane = gui.getContentPane();
        pane.setBackground(new Color(12, 34, 50));
        pane.setLayout(new BorderLayout());

        pane.add(EAST, BorderLayout.EAST);
        pane.add(WEST, BorderLayout.WEST);
        pane.add(CENTER, BorderLayout.CENTER);
        pane.add(NORTH, BorderLayout.NORTH);
        pane.add(SOUTH, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this applicationâ€™s GUI.
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
