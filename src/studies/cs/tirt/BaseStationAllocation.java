package studies.cs.tirt;

import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;

import java.awt.GridLayout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.SwingConstants;

public class BaseStationAllocation extends JFrame {

	private JPanel contentPane;
	private JLabel numberOfTerminalsAutOfRangeLabel;

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
		
		/* create GUI */
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BaseStationAllocation.class
						.getResource("/studies/cs/tirt/gui/pictures/BS.png")));
		setTitle("BaseStationAllocation 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1245, 765);

		contentPane = new JPanel(new GridBagLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagConstraints gbcCTR = new GridBagConstraints();
		GridBagConstraints gbcArea = new GridBagConstraints();

		JPanel ctrPanel = new JPanel();
		JPanel areaPanel = new JPanel();

		gbcCTR.gridx = 0;
		gbcCTR.gridy = 0;
		gbcCTR.weightx = 0.1;
		gbcCTR.weighty = 1.0;
		gbcCTR.fill = GridBagConstraints.BOTH;
		contentPane.add(ctrPanel, gbcCTR);

		gbcArea.gridx = 1;
		gbcArea.gridy = 0;
		gbcArea.weightx = 0.9;
		gbcArea.weighty = 1.0;
		gbcArea.fill = GridBagConstraints.BOTH;
		contentPane.add(areaPanel, gbcArea);

		GridBagLayout gbl_ctrPanel = new GridBagLayout();
		gbl_ctrPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_ctrPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gbl_ctrPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_ctrPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		ctrPanel.setLayout(gbl_ctrPanel);

		JLabel lblNewLabel = new JLabel("Choosen algorithm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 7, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		ctrPanel.add(lblNewLabel, gbc_lblNewLabel);

		JRadioButton rdbtnAlgorithm_1 = new JRadioButton("Algorithm1");
		rdbtnAlgorithm_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_rdbtnAlgorithm_1 = new GridBagConstraints();
		gbc_rdbtnAlgorithm_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAlgorithm_1.gridx = 0;
		gbc_rdbtnAlgorithm_1.gridy = 3;
		ctrPanel.add(rdbtnAlgorithm_1, gbc_rdbtnAlgorithm_1);

		JRadioButton rdbtnAlgorithm_2 = new JRadioButton("Algorithm2");
		rdbtnAlgorithm_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_rdbtnAlgorithm_2 = new GridBagConstraints();
		gbc_rdbtnAlgorithm_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAlgorithm_2.gridx = 0;
		gbc_rdbtnAlgorithm_2.gridy = 4;
		ctrPanel.add(rdbtnAlgorithm_2, gbc_rdbtnAlgorithm_2);

		JRadioButton rdbtnAlgorithm_3 = new JRadioButton("Algorithm3");
		rdbtnAlgorithm_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_rdbtnAlgorithm_3 = new GridBagConstraints();
		gbc_rdbtnAlgorithm_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAlgorithm_3.gridx = 0;
		gbc_rdbtnAlgorithm_3.gridy = 5;
		ctrPanel.add(rdbtnAlgorithm_3, gbc_rdbtnAlgorithm_3);

		JLabel lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblRating = new GridBagConstraints();
		gbc_lblRating.insets = new Insets(0, 0, 5, 5);
		gbc_lblRating.gridx = 0;
		gbc_lblRating.gridy = 8;
		ctrPanel.add(lblRating, gbc_lblRating);

		JLabel lblFirstRanking = new JLabel("first ranking");
		lblFirstRanking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFirstRanking = new GridBagConstraints();
		gbc_lblFirstRanking.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstRanking.gridx = 0;
		gbc_lblFirstRanking.gridy = 10;
		ctrPanel.add(lblFirstRanking, gbc_lblFirstRanking);

		numberOfTerminalsAutOfRangeLabel = new JLabel("New label");
		numberOfTerminalsAutOfRangeLabel
				.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.ipady = 10;
		gbc_lblNewLabel_2.ipadx = 20;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 10;
		ctrPanel.add(numberOfTerminalsAutOfRangeLabel, gbc_lblNewLabel_2);

		JLabel lblSecondRanking = new JLabel("second ranking");
		lblSecondRanking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSecondRanking = new GridBagConstraints();
		gbc_lblSecondRanking.insets = new Insets(0, 0, 0, 5);
		gbc_lblSecondRanking.gridx = 0;
		gbc_lblSecondRanking.gridy = 11;
		ctrPanel.add(lblSecondRanking, gbc_lblSecondRanking);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.ipady = 10;
		gbc_lblNewLabel_1.ipadx = 20;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 11;
		ctrPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAlgorithm_1);
		group.add(rdbtnAlgorithm_2);
		group.add(rdbtnAlgorithm_3);
	
		
		/* Arrange elements into area, and print them  */
		areaPanel.setLayout(new GridLayout(1, 1));
		GraphicalArea gArea = new GraphicalArea();
		areaPanel.add(gArea);
	}
	
	class GraphicalArea extends JPanel {
		Area cityArea = new Area();
			
		@Override
		public void paintComponent(Graphics g) {			
			Graphics2D g2 = (Graphics2D) g;
			
			Rectangle2D rect;
			float r;
			/*draw all base stations*/
			for (BaseTransceiverStation b : cityArea.getBaseStations()) {
				g2.setPaint(b.getColor());
				rect = new Rectangle2D.Float(b.getBtsPosition().getX(), b
						.getBtsPosition().getY(), 5, 10);
				g2.draw(rect);
				g2.fill(rect);
				r = b.getSignalStrength();
				g2.draw(new Ellipse2D.Double(b.getBtsPosition().getX() - r, b
						.getBtsPosition().getY() - r, 2 * r, 2 * r));
			}

			/*draw all terminals*/
			g2.setPaint(Color.BLACK);		
			for (Terminal t : cityArea.getTerminals()) {
				rect = new Rectangle2D.Float(t.getTerminalPosition().getX(), t
						.getTerminalPosition().getY(), 3, 3);
				t.setGraphicalRectOfThisTerminal(rect);
				g2.draw(rect);
			}

			//bruteAllocation();
			//colorTerminals(g2);
			//colorTerminalsInRangeOfBts(g2);
		}
		
		
	}

}
