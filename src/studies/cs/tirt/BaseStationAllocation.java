package studies.cs.tirt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
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
		gbl_ctrPanel.columnWidths = new int[]{0, 0, 0};
		gbl_ctrPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_ctrPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_ctrPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		numberOfTerminalsAutOfRangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		//Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnAlgorithm_1);
	    group.add(rdbtnAlgorithm_2);
	    group.add(rdbtnAlgorithm_3);
	   		
		areaPanel.setLayout(new GridLayout(1,1));
		Area cityArea = new Area();
		areaPanel.add(cityArea);		
	}	
	
	class Area extends JComponent{
		
		private float areaLengthX = 1000F;
		private float areaLengthY = 700F;
		
		private Set<BaseTransceiverStation> baseStations = new TreeSet<BaseTransceiverStation>();
		private Set<Terminal> terminals = new TreeSet<Terminal>();	
		
		private Random rand = new Random(13);
		private int numberOfTerminalsAutOfRange;
		
		public Area() {			
			arrangeBTS();
			arrangeTerminals();
			searchBTSInRangeOfTerminals();
			printNumberOfTerminalsAutOfRange();
		}
		
		public Area(float areaLengthX, float areaLengthY) {
			this();
			this.areaLengthX = areaLengthX;
			this.areaLengthY = areaLengthY;
		}
		
		public void arrangeBTS(){
			arrangeNBaseStations(463, 347, 230, 15);			
		}
		
		public void arrangeTerminals(){
			//arangeNTerminalsInAreaCircle(443, 340, 200, 200);
			arangeNTerminalsInAreaSquare(443, 340, 250, 250);			
		}	
		
		private void arrangeNBaseStations(float x, float y, float radius, int N){
			int addedElements = 0;
			while(addedElements<N) {			
				float bsX = x + (randomSign()* rand.nextFloat() * radius);
				float bsY = y + (randomSign()* rand.nextFloat() * radius);
				if (correctPosition(bsX, bsY)){
					baseStations.add(new BaseTransceiverStation(bsX, bsY));
					addedElements++;
				}
			}
		}
		
		//
		private void arangeNTerminalsInAreaSquare(float x, float y, float radius, int N) {
			int addedElements = 0;
			while(addedElements<N) {			
				float terminalX = x + (randomSign()* rand.nextFloat() * radius);
				float terminalY = y + (randomSign()* rand.nextFloat() * radius);
				if (correctPosition(terminalX, terminalY)){
					terminals.add(new Terminal(terminalX, terminalY));
					addedElements++;
				}
			}		
		}
		
		private void arangeNTerminalsInAreaCircle(float x, float y, float radius, int N) {
			int i = 0;
			int addedElements = 0;
			while(addedElements<N) {			
				float terminalX = x + (randomSign()* rand.nextFloat() * radius);				
				float terminalY = y +  (randomSign() * rand.nextFloat() * 
						(float) Math.sqrt(Math.pow(radius, 2)-Math.pow(terminalX-x, 2))); // normalization y value (it couldn't be bigger than this radical) to get a circle
				if (correctPosition(terminalX, terminalY)){
					terminals.add(new Terminal(terminalX, terminalY));
					addedElements++;
				}
			}		
		}
		
		private float randomSign(){
			return ((rand.nextInt() % 2) == 0)? 1.0F : -1.0F;	
		}
		
		private boolean correctPosition(float x, float y) {		
			return (x >= 0.0F) && (x <= areaLengthX) &&
					(y >= 0.0F) && (y <= areaLengthY);
		}

		public Set<BaseTransceiverStation> getBaseStations() {
			return baseStations;
		}

		public Set<Terminal> getTerminals() {
			return terminals;
		}
		
		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D) g;			
			
			Rectangle2D rect;
			float r;			
			for (BaseTransceiverStation b : baseStations) {	
				g2.setPaint(b.getColor());
				rect = new Rectangle2D.Float(b.getX(), b.getY(), 5,10);
				g2.draw(rect);
				g2.fill(rect);
				r = b.getSignalStrength();				
				g2.draw(new Ellipse2D.Double(b.getX()-r, b.getY() -r, 2*r, 2*r));
			}
			
			g2.setPaint(Color.BLACK);
			for (Terminal t : terminals) {
				rect = new Rectangle2D.Float(t.getX(), t.getY(), 3,3);
				t.setRectOfThisTerminal(rect);
				g2.draw(rect);
			}		
			
		}	
		
		private void searchBTSInRangeOfTerminals() {
			for (Terminal t : terminals) {
				for (BaseTransceiverStation bts : baseStations) {
					if (calculateDistance(bts.getX(), bts.getY(), t.getX(), t.getY())<=bts.getSignalStrength()){
						bts.getTerminals().add(t);
						t.getBTSInRange().add(bts);
					}
				}
			}
		}
		
		private float calculateDistance(float x1, float y1, float x2, float y2) {
			return (float) Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		}
		
		public void countTerminalsAutOfRange() {
			numberOfTerminalsAutOfRange = 0;	
			for (Terminal t : terminals) {
				if(t.getBTSInRange().isEmpty())
					numberOfTerminalsAutOfRange++;
			}			
		}
		
		private void printNumberOfTerminalsAutOfRange() {
			countTerminalsAutOfRange();
			numberOfTerminalsAutOfRangeLabel.setText(""+numberOfTerminalsAutOfRange);
		}
		
		private void colorTerminals(Graphics2D g2) {
			for (BaseTransceiverStation bts : baseStations) {
				g2.setColor(bts.getColor());
				for (Terminal t : bts.) {
					
				}
			}
		}
	}
}
