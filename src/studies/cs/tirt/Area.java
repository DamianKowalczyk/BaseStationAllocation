package studies.cs.tirt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Area extends JComponent {

	private float areaLengthX = 1000F;
	private float areaLengthY = 700F;

	private Set<BaseTransceiverStation> baseStations = new TreeSet<BaseTransceiverStation>();
	private Set<Terminal> terminals = new TreeSet<Terminal>();

	private Set<Terminal> allocatedTerminals = new TreeSet<Terminal>();

	private Random rand = new Random(13);
	private int numberOfTerminalsAutOfRange;
	
	private JLabel numberOfTerminalsAutOfRangeLabel;
	
	
	public Area() {		
		arrangeBTS();
		arrangeTerminals();
		searchBTSsInRangeOfTerminals();
		//printTerminalsAutOfRangeNumber();
	}

	/*public Area() {		
		arrangeBTS();
		arrangeTerminals();
		searchBTSsInRangeOfTerminals();
		printTerminalsAutOfRangeNumber();
	}*/

	/*public Area(float areaLengthX, float areaLengthY) {
		this();
		this.areaLengthX = areaLengthX;
		this.areaLengthY = areaLengthY;
	}*/

	public void arrangeBTS() {
		arrangeNBaseStations(463, 347, 230, 15);
	}

	public void arrangeTerminals() {
		// arangeNTerminalsInAreaCircle(443, 340, 200, 200);
		arangeNTerminalsInSquareArea(443, 340, 250, 250);
	}

	private void arrangeNBaseStations(float x, float y, float radius, int N) {
		int addedElements = 0;
		while (addedElements < N) {
			float bsX = x + (randomSign() * rand.nextFloat() * radius);
			float bsY = y + (randomSign() * rand.nextFloat() * radius);
			if (isPointInArea(bsX, bsY)) {
				baseStations.add(new BaseTransceiverStation(bsX, bsY));
				addedElements++;
			}
		}
	}

	//
	private void arangeNTerminalsInSquareArea(float x, float y,
			float radius, int N) {
		int addedElements = 0;
		while (addedElements < N) {
			float terminalX = x
					+ (randomSign() * rand.nextFloat() * radius);
			float terminalY = y
					+ (randomSign() * rand.nextFloat() * radius);
			if (isPointInArea(terminalX, terminalY)) {
				terminals.add(new Terminal(terminalX, terminalY));
				addedElements++;
			}
		}
	}

	private void arangeNTerminalsInCircleArea(float x, float y,
			float radius, int N) {
		int i = 0;
		int addedElements = 0;
		while (addedElements < N) {
			float terminalX = x
					+ (randomSign() * rand.nextFloat() * radius);
			float terminalY = y
					+ (randomSign() * rand.nextFloat() * (float) Math
							.sqrt(Math.pow(radius, 2)
									- Math.pow(terminalX - x, 2)));
			/*
			 * normalization value (it couldn't be bigger than this radical)
			 * to get a circle *
			 */
			if (isPointInArea(terminalX, terminalY)) {
				terminals.add(new Terminal(terminalX, terminalY));
				addedElements++;
			}
		}
	}

	private float randomSign() {
		return ((rand.nextInt() % 2) == 0) ? 1.0F : -1.0F;
	}

	private boolean isPointInArea(float x, float y) {
		return (x >= 0.0F) && (x <= areaLengthX) && (y >= 0.0F)
				&& (y <= areaLengthY);
	}

	public Set<BaseTransceiverStation> getBaseStations() {
		return baseStations;
	}

	public Set<Terminal> getTerminals() {
		return terminals;
	}

	/*public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Rectangle2D rect;
		float r;
		for (BaseTransceiverStation b : baseStations) {
			g2.setPaint(b.getColor());
			rect = new Rectangle2D.Float(b.getBtsPosition().getX(), b
					.getBtsPosition().getY(), 5, 10);
			g2.draw(rect);
			g2.fill(rect);
			r = b.getSignalStrength();
			g2.draw(new Ellipse2D.Double(b.getBtsPosition().getX() - r, b
					.getBtsPosition().getY() - r, 2 * r, 2 * r));
		}

		g2.setPaint(Color.BLACK);
		for (Terminal t : terminals) {
			rect = new Rectangle2D.Float(t.getTerminalPosition().getX(), t
					.getTerminalPosition().getY(), 3, 3);
			t.setGraphicalRectOfThisTerminal(rect);
			g2.draw(rect);
		}

		bruteAllocation();
		colorTerminals(g2);
		colorTerminalsInRangeOfBts(g2);

	}*/

	private void searchBTSsInRangeOfTerminals() {
		for (Terminal t : terminals) {
			for (BaseTransceiverStation bts : baseStations) {
				if (Point.calculateDistanceBetweenTwoPoints(
						t.getTerminalPosition(), bts.getBtsPosition()) <= bts
						.getSignalStrength()) {
					bts.getTerminalsInRange().add(t);
					t.getBTSInRange().add(bts);
				}
			}
		}
	}

	public void countTerminalsAutOfRange() {
		numberOfTerminalsAutOfRange = 0;
		for (Terminal t : terminals) {
			if (t.getBTSInRange().isEmpty())
				numberOfTerminalsAutOfRange++;
		}
	}

	private void printTerminalsAutOfRangeNumber() {
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
	}

	// it will allocate max number of nearby terminals for each Base Station
	private void bruteAllocation() {
		for (BaseTransceiverStation currentBts : baseStations) {
			allocateMaxNumberTerminalsInRange(currentBts);
		}

	}

	private void allocateMaxNumberTerminalsInRange(
			BaseTransceiverStation currentBts) {

		Terminal tmpTerminal;
		Object[] terminalsInRange = currentBts.getTerminalsInRange()
				.toArray();

		int index = 0;
		int numberOfCopiedTerminals = 0;

		while (index < terminalsInRange.length
				&& numberOfCopiedTerminals < currentBts
						.getNumberAllowedTerminals()) {

			tmpTerminal = (Terminal) terminalsInRange[index];
			if (!allocatedTerminals.contains(tmpTerminal)) {
				currentBts.connectTerminal(tmpTerminal);
				tmpTerminal.setAllocatedBts(currentBts);
			}

			index++;
		}
	}

}
