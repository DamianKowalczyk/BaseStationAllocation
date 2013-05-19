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
import javax.swing.JRadioButton;
import javax.swing.JLabel;

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

		GridBagConstraints gbcCTR = new GridBagConstraints();
		GridBagConstraints gbcArea = new GridBagConstraints();
		
		JPanel ctrPanel = new JPanel();
		JPanel areaPanel = new JPanel();
		
		gbcCTR.gridx = 0;
		gbcCTR.gridy = 0;		
		gbcCTR.weightx = 0.2;
		gbcCTR.weighty = 1.0;
		gbcCTR.fill = GridBagConstraints.BOTH;
		contentPane.add(ctrPanel, gbcCTR);		
		GridBagLayout gbl_ctrPanel = new GridBagLayout();
		gbl_ctrPanel.columnWidths = new int[]{0, 0};
		gbl_ctrPanel.rowHeights = new int[]{0, 0};
		gbl_ctrPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_ctrPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		ctrPanel.setLayout(gbl_ctrPanel);
		
		JLabel lblNewLabel = new JLabel("Choosen algorithm:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		ctrPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		gbcArea.gridx = 1;
		gbcArea.gridy = 0;
		gbcArea.weightx = 0.8;
		gbcArea.weighty = 1.0;
		gbcArea.fill = GridBagConstraints.BOTH;
		contentPane.add(areaPanel, gbcArea);
		
		/*JRadioButton rdbtnNewRadioButton = new JRadioButton("Algorithm1");
		ctrPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Algorithm2");
		ctrPanel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnAlgorithm = new JRadioButton("Algorithm3");
		ctrPanel.add(rdbtnAlgorithm);*/
		
		
		
		//contentPane.add(areaPanel, gbc);
		
		/*GridBagConstraints c = new GridBagConstraints();
		JButton button;
		button = new JButton("Button 1");

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.3;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		contentPane.add(button, gbc);

		button = new JButton("Button 2");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.7;
		c.gridx = 1;
		c.gridy = 0;
		c.weighty = 1.0;
		contentPane.add(button, c);*/
		
	}
}
