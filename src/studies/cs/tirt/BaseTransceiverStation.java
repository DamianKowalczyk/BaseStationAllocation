package studies.cs.tirt;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class BaseTransceiverStation implements
		Comparable<BaseTransceiverStation> {

	// position
	private float x;
	private float y;

	private float signalStrength;
	private int numberOfAllowedTerminals;
	private Color color;
	
	private ArrayList<Terminal> connectedTerminals = new ArrayList<>();

	private static Random rand = new Random(13);
	
	public BaseTransceiverStation(float x, float y) {
		super();
		this.x = x;
		this.y = y;
		this.signalStrength = 60.0F + rand.nextFloat() * 20.0f;
		this.numberOfAllowedTerminals = (int) (10 + rand.nextFloat() * 6);
		this.color = Colors.getColor((int) (rand.nextFloat() * 11));
	}

	public BaseTransceiverStation(float x, float y, float signalStrength,
			int numberAllowedTerminals) {
		this(x, y);
		this.signalStrength = signalStrength;
		this.numberOfAllowedTerminals = numberAllowedTerminals;
	}

	public boolean equals(Object o) {
		return (o instanceof BaseTransceiverStation)
				&& (x == ((BaseTransceiverStation) o).getX() && y == ((BaseTransceiverStation) o)
						.getY()); 
			// two base stations are equal when are in the same place
	}

	@Override
	public int compareTo(BaseTransceiverStation o) {
		double distThis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double distO = Math.sqrt(Math.pow(o.getX(), 2) + Math.pow(o.getY(), 2));

		return distThis > distO ? 1 : (distThis == distO ? 0 : -1);
	}

	/* ********** getters and setters **************** */

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getSignalStrength() {
		return signalStrength;
	}

	public int getNumberAllowedTerminals() {
		return numberOfAllowedTerminals;
	}

	public ArrayList<Terminal> getTerminals() {
		return connectedTerminals;
	}

	public void setTerminals(ArrayList<Terminal> terminals) {
		this.connectedTerminals = terminals;
	}

	public Color getColor() {
		return color;
	}

}
