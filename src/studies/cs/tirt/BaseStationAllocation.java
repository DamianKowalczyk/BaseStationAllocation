package studies.cs.tirt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JSplitPane;

import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BaseStationAllocation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseStationAllocation frame = new BaseStationAllocation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BaseStationAllocation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BaseStationAllocation.class
						.getResource("/studies/cs/tirt/gui/pictures/BS.png")));
		setTitle("BaseStationAllocation 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1237, 766);

		contentPane = new JPanel(new GridBagLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagConstraints gbc = new GridBagConstraints();

		GridBagConstraints c = new GridBagConstraints();
		JButton button;
		button = new JButton("Button 1");

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.3;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1.0;
		contentPane.add(button, c);

		button = new JButton("Button 2");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.7;
		c.gridx = 1;
		c.gridy = 0;
		c.weighty = 1.0;
		contentPane.add(button, c);

		/*
		 * Button b1 = new Button("control"); Button b2 = new Button("area");
		 * 
		 * JPanel ctrPanel = new JPanel(); JPanel areaPanel = new JPanel();
		 * 
		 * gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
		 * 
		 * gbc.fill = GridBagConstraints.HORIZONTAL; contentPane.add(b1, gbc);
		 * //contentPane.add(ctrPanel, gbc);
		 * 
		 * 
		 * gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.7; gbc.fill =
		 * GridBagConstraints.HORIZONTAL; contentPane.add(b2, gbc);
		 * //contentPane.add(areaPanel, gbc);
		 */
		/*
		 * GridBagConstraints gbc = new GridBagConstraints(); gbc.gridheight =
		 * 1; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
		 * 
		 * JPanel ctrPanel = new JPanel(); gbc.gridy = 1; gbc.gridx = 1;
		 * gbc.weightx = 0.3; contentPane.add(ctrPanel, gbc);
		 */

	}
}
