package midtermLib;

import java.math.BigDecimal;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

public class Listselection {

	JFrame frame = new JFrame("Grand Circus Library");

	JList<Product> list = new JList<>();
	DefaultListModel<Product> model = new DefaultListModel<>();
	JButton button = new JButton();
	JLabel label = new JLabel();
	JPanel panel = new JPanel();

	JSplitPane splitPane = new JSplitPane();

	private JButton North;
	private JButton South;

	public Listselection() {

		list.setModel(model);
		model.addElement(new Product("Oranges", new BigDecimal("2.00"), "These are fresh"));
		model.addElement(new Product("Apples", new BigDecimal("1.75"), "These are HoneyCrisps!"));

		list.getSelectionModel().addListSelectionListener(e -> {
			Product p = list.getSelectedValue();
		});

		splitPane.setLeftComponent(new JScrollPane(list));
		panel.add(label);
		splitPane.setRightComponent(button);
		// splitPane.setRightComponent(splitPane);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(splitPane);
		frame.setSize(500, 500);
		North = new JButton("Check out");
		South = new JButton("Main Menu");
//		frame.add(button);
//		frame.add(button);

	}

	private class Product {

		private String name;
		private BigDecimal price;
		private String desc;

		public Product(String name, BigDecimal price, String desc) {
			super();
			this.name = name;
			this.price = price;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return name + ", " + price + ", " + desc;
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Listselection::new);
	}

}
