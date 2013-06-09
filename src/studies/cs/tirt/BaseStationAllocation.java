package studies.cs.tirt;

import java.awt.EventQueue;
import javax.swing.ButtonGroup;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;

import java.awt.GridLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;


import javax.swing.SwingConstants;
import javax.swing.JButton;

public class BaseStationAllocation extends JFrame {

	private BaseStationAllocation thisObject;
	private JPanel contentPane;
	private JLabel percentAllocatedTerminals;
	
	private Area cityArea = new Area();
	GraphicalArea gArea = new GraphicalArea();
	JPanel areaPanel = new JPanel();
	
	

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
					BaseStationAllocation frame = new BaseStationAllocation("");
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
	public BaseStationAllocation(String algorithmName) {
				
		/* create GUI */
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BaseStationAllocation.class
						.getResource("/studies/cs/tirt/gui/pictures/BS.png")));
		setTitle("BaseStationAllocation 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 681);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		contentPane = new JPanel(gbl_contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagConstraints gbcCTR = new GridBagConstraints();
		GridBagConstraints gbcArea = new GridBagConstraints();
		gbcArea.anchor = GridBagConstraints.WEST;

		JPanel ctrPanel = new JPanel();
		/*JPanel areaPanel = new JPanel();*/

		gbcCTR.gridx = 0;
		gbcCTR.gridy = 0;
		gbcCTR.weightx = 0.05;
		gbcCTR.weighty = 1.0;
		gbcCTR.fill = GridBagConstraints.BOTH;
		contentPane.add(ctrPanel, gbcCTR);

		gbcArea.gridx = 1;
		gbcArea.gridy = 0;
		gbcArea.weightx = 0.95;
		gbcArea.weighty = 1.0;
		gbcArea.fill = GridBagConstraints.BOTH;
		contentPane.add(areaPanel, gbcArea);

		GridBagLayout gbl_ctrPanel = new GridBagLayout();
		gbl_ctrPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_ctrPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_ctrPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_ctrPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		ctrPanel.setLayout(gbl_ctrPanel);

		JLabel lblNewLabel = new JLabel("Choosen algorithm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 7, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		ctrPanel.add(lblNewLabel, gbc_lblNewLabel);

		JRadioButton maxNumNearestUpLeftCorner = new JRadioButton("maxNumNearestUpLeftCorner");
		maxNumNearestUpLeftCorner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_maxNumNearestUpLeftCorner = new GridBagConstraints();
		gbc_maxNumNearestUpLeftCorner.anchor = GridBagConstraints.WEST;
		gbc_maxNumNearestUpLeftCorner.insets = new Insets(0, 0, 5, 5);
		gbc_maxNumNearestUpLeftCorner.gridx = 0;
		gbc_maxNumNearestUpLeftCorner.gridy = 3;
		ctrPanel.add(maxNumNearestUpLeftCorner, gbc_maxNumNearestUpLeftCorner);

		JRadioButton maxNumberNearestBts = new JRadioButton("maxNumberNearestBts");
		maxNumberNearestBts.setHorizontalAlignment(SwingConstants.LEFT);
		maxNumberNearestBts.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_maxNumberNearestBts = new GridBagConstraints();
		gbc_maxNumberNearestBts.anchor = GridBagConstraints.WEST;
		gbc_maxNumberNearestBts.insets = new Insets(0, 0, 5, 5);
		gbc_maxNumberNearestBts.gridx = 0;
		gbc_maxNumberNearestBts.gridy = 4;
		ctrPanel.add(maxNumberNearestBts, gbc_maxNumberNearestBts);

		JRadioButton firstTerminalsInRangeOfOneBts = new JRadioButton("firstTerminalsInRangeOfOneBts");
		firstTerminalsInRangeOfOneBts.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_firstTerminalsInRangeOfOneBts = new GridBagConstraints();
		gbc_firstTerminalsInRangeOfOneBts.anchor = GridBagConstraints.WEST;
		gbc_firstTerminalsInRangeOfOneBts.insets = new Insets(0, 0, 5, 5);
		gbc_firstTerminalsInRangeOfOneBts.gridx = 0;
		gbc_firstTerminalsInRangeOfOneBts.gridy = 5;
		ctrPanel.add(firstTerminalsInRangeOfOneBts, gbc_firstTerminalsInRangeOfOneBts);
		
		JRadioButton maxNumberRandomized = new JRadioButton("maxNumberRandomized");
		maxNumberRandomized.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_maxNumberRandomized = new GridBagConstraints();
		gbc_maxNumberRandomized.anchor = GridBagConstraints.WEST;
		gbc_maxNumberRandomized.insets = new Insets(0, 0, 5, 5);
		gbc_maxNumberRandomized.gridx = 0;
		gbc_maxNumberRandomized.gridy = 6;
		ctrPanel.add(maxNumberRandomized, gbc_maxNumberRandomized);
		
		JButton btnRandom = new JButton("Random");
		GridBagConstraints gbc_btnRandom = new GridBagConstraints();
		gbc_btnRandom.insets = new Insets(0, 0, 5, 0);
		gbc_btnRandom.gridx = 1;
		gbc_btnRandom.gridy = 6;
		ctrPanel.add(btnRandom, gbc_btnRandom);

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

		percentAllocatedTerminals = new JLabel("New label");
		percentAllocatedTerminals
				.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_percentAllocatedTerminals = new GridBagConstraints();
		gbc_percentAllocatedTerminals.ipady = 10;
		gbc_percentAllocatedTerminals.ipadx = 20;
		gbc_percentAllocatedTerminals.insets = new Insets(0, 0, 5, 0);
		gbc_percentAllocatedTerminals.gridx = 1;
		gbc_percentAllocatedTerminals.gridy = 10;
		ctrPanel.add(percentAllocatedTerminals, gbc_percentAllocatedTerminals);

		JLabel lblSecondRanking = new JLabel("second ranking");
		lblSecondRanking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSecondRanking = new GridBagConstraints();
		gbc_lblSecondRanking.insets = new Insets(0, 0, 5, 5);
		gbc_lblSecondRanking.gridx = 0;
		gbc_lblSecondRanking.gridy = 11;
		ctrPanel.add(lblSecondRanking, gbc_lblSecondRanking);

		JLabel averageDistance = new JLabel("New label");
		averageDistance.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_averageDistance = new GridBagConstraints();
		gbc_averageDistance.insets = new Insets(0, 0, 5, 0);
		gbc_averageDistance.ipady = 10;
		gbc_averageDistance.ipadx = 20;
		gbc_averageDistance.gridx = 1;
		gbc_averageDistance.gridy = 11;
		ctrPanel.add(averageDistance, gbc_averageDistance);		
		
		JLabel lblInfo = new JLabel("info");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 13;
		ctrPanel.add(lblInfo, gbc_lblInfo);
		
		JLabel lblNewLabel_2 = new JLabel("BTS number:");
		GridBagConstraints gbc_lblNewLabel_215 = new GridBagConstraints();		
		gbc_lblNewLabel_215.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_215.gridx = 0;
		gbc_lblNewLabel_215.gridy = 14;
		ctrPanel.add(lblNewLabel_2, gbc_lblNewLabel_215);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 14;
		ctrPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total terminal number:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 15;
		ctrPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 15;
		ctrPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Terminals out of range number:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 16;
		ctrPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 16;
		ctrPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Allocated Terminals number:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 17;
		ctrPanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 17;
		ctrPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Max number of terminals could be allocated ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 18;
		ctrPanel.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 18;
		ctrPanel.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		/* Group radio buttons */
		ButtonGroup group = new ButtonGroup();
		group.add(maxNumNearestUpLeftCorner);
		group.add(maxNumberNearestBts);
		group.add(firstTerminalsInRangeOfOneBts);
		group.add(maxNumberRandomized);
		
		cityArea.setRandom(new Random(13));
		cityArea.arrangeBTS();
		cityArea.arrangeTerminals();
		cityArea.searchBTSsInRangeOfTerminals();
		lblNewLabel_3.setText(""+cityArea.getBaseStations().size());
		lblNewLabel_5.setText(""+cityArea.getTerminals().size());
		lblNewLabel_7.setText(""+cityArea.countTerminalsAutOfRange());		
		lblNewLabel_11.setText(""+cityArea.countMaximalNumberOfTerminalsPossibleToAllocate());
		
		lblFirstRanking.setText("QualityOfAllocation");
		lblSecondRanking.setText("AverageDistanceBtTermAndBTs");
		
		
		switch (algorithmName) {
		case "maxNumNearestUpLeftCorner":
			cityArea.bruteAllocationNeardestUpLeftCorner();
			break;
		case "maxNumberNearestBts":
			cityArea.allocateMaxNumberOfTerminalsNeardestBTS();
			break;
		case "firstTerminalsInRangeOfOneBts":
			cityArea.allocateTerminalsFirstTerminalsNeardestAndInRangeOfOnlyOneBTS();
			break;
		case "maxNumberRandomized":
			cityArea.allocateRandomizedTerminals();
			break;
			
		default:
			break;
		}
	
		
		lblNewLabel_9.setText(""+cityArea.countAllocatedTerminals());
		percentAllocatedTerminals.setText(""+cityArea.countQualityOfAllocation());
		averageDistance.setText(""+cityArea.countPercentOfAllocation());
		
		/* Arrange elements into area, and print them  */
		/*areaPanel.setLayout(new GridLayout(1, 1));*/
		areaPanel.setLayout(new BorderLayout());
		areaPanel.add(gArea);
		
		maxNumNearestUpLeftCorner.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BaseStationAllocation frame = new BaseStationAllocation("maxNumNearestUpLeftCorner");
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				/*cityArea.restoreTerminalsAndBtsToStartPoint();
				cityArea.bruteAllocationNeardestUpLeftCorner();*/
				/*areaPanel.add(new GraphicalArea());*/
				//areaPanel.add(new GraphicalArea());
				//revalidate();
			}
		});
		
		maxNumberNearestBts.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BaseStationAllocation frame = new BaseStationAllocation("maxNumberNearestBts");
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				/*cityArea.restoreTerminalsAndBtsToStartPoint();
				cityArea.allocateMaxNumberOfTerminalsNeardestBTS();*/
			}
		});
		
		firstTerminalsInRangeOfOneBts.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BaseStationAllocation frame = new BaseStationAllocation("firstTerminalsInRangeOfOneBts");
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				/*cityArea.restoreTerminalsAndBtsToStartPoint();
				cityArea.allocateMaxNumberOfTerminalsNeardestBTS();*/
			}
		});
		
		maxNumberRandomized.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BaseStationAllocation frame = new BaseStationAllocation("maxNumberRandomized");
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				/*cityArea.restoreTerminalsAndBtsToStartPoint();
				cityArea.allocateMaxNumberOfTerminalsNeardestBTS();*/
			}
		});
		
	}
		
	
	class GraphicalArea extends JPanel {
		
		
		
		
		public GraphicalArea() {
			/*cityArea.arrangeBTS();
			cityArea.arrangeTerminals();
			cityArea.searchBTSsInRangeOfTerminals();*/
			//cityArea.bruteAllocationNeardestUpLeftCorner();
			//cityArea.allocateMaxNumberOfTerminalsNeardestBTS();
			//cityArea.allocateTerminalsFirstTerminalsNeardestAndInRangeOfOnlyOneBTS();
			//cityArea.allocateRandomizedTerminals();		
		}
			
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
			
			colourTerminalsAoutOFrange(g2);
			colourAllocatedTerminals(g2);
			//greyTerminalsAoutOFrange(g2);			
			//colorTerminals(g2);
			//colorTerminalsInRangeOfBts(g2);
		}
		
		private void colourTerminalsAoutOFrange(Graphics2D g2) {
			g2.setColor(Color.RED);
			for (Terminal t : cityArea.getTerminals()) {
				if (t.getBTSInRange().isEmpty())
					g2.fill(t.getGraphicalRectOfThisTerminal());
			}
		}
		
		private void colourAllocatedTerminals(Graphics2D g2){
			for (Terminal t : cityArea.getTerminals()) {
				if (t.getAllocatedBts()!=null){
					g2.setColor(t.getAllocatedBts().getColor());
					g2.fill(t.getGraphicalRectOfThisTerminal());
				}				
			}
		}
		
		/*private void printTerminalsAutOfRangeNumber() {
			countTerminalsAutOfRange();
			numberOfTerminalsAutOfRangeLabel.setText(""
					+ numberOfTerminalsAutOfRange);
		}

		private void colorTerminals(Graphics2D g2) {
			for (BaseTransceiverStation bts : baseStations) {
				g2.setColor(bts.getColor());
				for (Terminal t : bts.getConnectedTerminals()) {
					g2.fill(t.getGraphicalRectOfThisTerminal());
				}
			}
		}
		
		private void colorTerminalsInRangeOfBts(Graphics2D g2){
			for (BaseTransceiverStation bts : baseStations) {
				g2.setColor(bts.getColor());
				for (Terminal t : bts.getTerminalsInRange()) {
					g2.fill(t.getGraphicalRectOfThisTerminal());
				}
			}
		}*/	
		
		/*public void fillTerminalsOutOfRange() {
			
		}*/
		
		
	}

}
