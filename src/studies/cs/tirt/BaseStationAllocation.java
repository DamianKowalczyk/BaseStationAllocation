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
		gbl_ctrPanel.columnWidths = new int[]{0, 0, 0};
		gbl_ctrPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_ctrPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_ctrPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		ctrPanel.setLayout(gbl_ctrPanel);
		
		JLabel lblNewLabel = new JLabel("Choosen algorithm:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		ctrPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JRadioButton rdbtnAlgorithm = new JRadioButton("Algorithm1");
		GridBagConstraints gbc_rdbtnAlgorithm = new GridBagConstraints();
		gbc_rdbtnAlgorithm.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAlgorithm.gridx = 0;
		gbc_rdbtnAlgorithm.gridy = 2;
		ctrPanel.add(rdbtnAlgorithm, gbc_rdbtnAlgorithm);
		
		JRadioButton rdbtnAlgorithm_1 = new JRadioButton("Algorithm2");
		GridBagConstraints gbc_rdbtnAlgorithm_1 = new GridBagConstraints();
		gbc_rdbtnAlgorithm_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAlgorithm_1.gridx = 0;
		gbc_rdbtnAlgorithm_1.gridy = 3;
		ctrPanel.add(rdbtnAlgorithm_1, gbc_rdbtnAlgorithm_1);
		
		JRadioButton rdbtnAlgorithm_2 = new JRadioButton("Algorithm3");
		GridBagConstraints gbc_rdbtnAlgorithm_2 = new GridBagConstraints();
		gbc_rdbtnAlgorithm_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAlgorithm_2.gridx = 0;
		gbc_rdbtnAlgorithm_2.gridy = 4;
		ctrPanel.add(rdbtnAlgorithm_2, gbc_rdbtnAlgorithm_2);
		
		JLabel lblRating = new JLabel("Rating");
		GridBagConstraints gbc_lblRating = new GridBagConstraints();
		gbc_lblRating.insets = new Insets(0, 0, 5, 5);
		gbc_lblRating.gridx = 0;
		gbc_lblRating.gridy = 8;
		ctrPanel.add(lblRating, gbc_lblRating);
		
		JLabel lblFirstRanking = new JLabel("first ranking");
		GridBagConstraints gbc_lblFirstRanking = new GridBagConstraints();
		gbc_lblFirstRanking.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstRanking.gridx = 0;
		gbc_lblFirstRanking.gridy = 10;
		ctrPanel.add(lblFirstRanking, gbc_lblFirstRanking);
		
		JLabel lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 10;
		ctrPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblSecondRanking = new JLabel("second ranking");
		GridBagConstraints gbc_lblSecondRanking = new GridBagConstraints();
		gbc_lblSecondRanking.insets = new Insets(0, 0, 0, 5);
		gbc_lblSecondRanking.gridx = 0;
		gbc_lblSecondRanking.gridy = 11;
		ctrPanel.add(lblSecondRanking, gbc_lblSecondRanking);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 11;
		ctrPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		gbcArea.gridx = 1;
		gbcArea.gridy = 0;
		gbcArea.weightx = 0.8;
		gbcArea.weighty = 1.0;
		gbcArea.fill = GridBagConstraints.BOTH;
		contentPane.add(areaPanel, gbcArea);
		
		
	}
}
