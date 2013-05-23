package studies.cs.tirt;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class BaseTransceiverStation implements
		Comparable<BaseTransceiverStation> {

	// position	
	private Point btsPosition;

	private float signalStrength;
	private int numberOfAllowedTerminals;
	private Color color;
	
	private SortedSet<Terminal> terminalsInRange = new TreeSet<Terminal>();
	private ArrayList<Terminal> connectedTerminals = new ArrayList<>();

	private static Random rand = new Random(13);
	
	public BaseTransceiverStation(float x, float y) {
		super();		
		btsPosition = new Point(x, y);
		this.signalStrength = 60.0F + rand.nextFloat() * 20.0f;
		this.numberOfAllowedTerminals = (int) (10 + rand.nextFloat() * 6);
		this.color = Colors.getColor((int) (rand.nextFloat() * 11));
	}

	/*public BaseTransceiverStation(float x, float y, float signalStrength,
			int numberAllowedTerminals) {
		this(x, y);
		this.signalStrength = signalStrength;
		this.numberOfAllowedTerminals = numberAllowedTerminals;
	}*/

	public boolean equals(Object o) {
		return (o instanceof BaseTransceiverStation)
				&& (btsPosition.equals(((BaseTransceiverStation) o).getBtsPosition()));
	}

	@Override
	public int compareTo(BaseTransceiverStation o) {
		return getBtsPosition().compareTo(o.getBtsPosition());
	}

	/* ********** getters and setters **************** */


	public float getSignalStrength() {
		return signalStrength;
	}

	public int getNumberAllowedTerminals() {
		return numberOfAllowedTerminals;
	}

	public ArrayList<Terminal> getConnectedTerminals() {
		return connectedTerminals;
	}

	public void setConnectedTerminals(ArrayList<Terminal> terminals) {
		this.connectedTerminals = terminals;
	}	

	public SortedSet<Terminal> getTerminalsInRange() {
		return terminalsInRange;
	}

	public void setTerminalsInRange(SortedSet<Terminal> terminalsInRange) {
		this.terminalsInRange = terminalsInRange;
	}

	public Color getColor() {
		return color;
	}

	public Point getBtsPosition() {
		return btsPosition;
	}	

}
