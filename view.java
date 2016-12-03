package views;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.Border;
public class view {

	public static void main(String[] args) {
		JFrame frame = new JFrame("The Title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panOuter = new JPanel(new BorderLayout());
		JPanel panLeft = new JPanel(new BorderLayout());
		panLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panRight = new JPanel(new BorderLayout());
		panRight.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panBottom = new JPanel(); // default is FlowLayout
		panBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel panInput = new JPanel(new BorderLayout());
		panInput.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel panConsole = new JPanel(new BorderLayout());

		Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border insideBorder = BorderFactory.createTitledBorder("The Console");
		Border theBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
		panConsole.setBorder(theBorder);

		panInput.add(panLeft, BorderLayout.WEST);
		panInput.add(panRight, BorderLayout.EAST);
		panInput.add(panBottom, BorderLayout.SOUTH);

		panOuter.add(panInput, BorderLayout.NORTH);
		panOuter.add(panConsole, BorderLayout.CENTER);

		JLabel lblLeft = new JLabel("Label 1", JLabel.CENTER);
		JLabel lblRight = new JLabel("Label 2", JLabel.CENTER);

		JTextField txtLeft = new JTextField(10);
		JTextField txtLright = new JTextField(10);

		JButton btnBottom = new JButton("Press it!");

		JTextArea txtConsole = new JTextArea(5, 10);

		JScrollPane srcPane = new JScrollPane(txtConsole,
		            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panLeft.add(lblLeft, BorderLayout.NORTH);
		panLeft.add(txtLeft, BorderLayout.CENTER);

		panRight.add(lblRight, BorderLayout.NORTH);
		panRight.add(txtLright, BorderLayout.CENTER);

		panBottom.add(btnBottom);

		panConsole.add(srcPane, BorderLayout.CENTER);

		frame.setContentPane(panOuter);
		frame.pack();
		frame.setVisible(true);
	}
}
