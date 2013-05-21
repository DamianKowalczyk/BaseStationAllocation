package studies.cs.tirt;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Terminal implements Comparable<Terminal> {

	private float x;
	private float y;

	private BaseTransceiverStation bts = null;
	private ArrayList<BaseTransceiverStation> BTSInRange = new ArrayList<BaseTransceiverStation>();
	
	private Rectangle2D rectOfThisTerminal;

	public Terminal(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object o) {
		return (o instanceof Terminal)
				&& (x == ((Terminal) o).getX() && y == ((Terminal) o).getY());
		// two terminals are equal when are in the same place
	}

	@Override
	public int compareTo(Terminal o) {
		double distThis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double distO = Math.sqrt(Math.pow(o.getX(), 2) + Math.pow(o.getY(), 2));

		return distThis > distO ? 1 : (distThis == distO ? 0 : -1);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public BaseTransceiverStation getBts() {
		return bts;
	}

	public void setBts(BaseTransceiverStation bts) {
		this.bts = bts;
	}

	public ArrayList<BaseTransceiverStation> getBTSInRange() {
		return BTSInRange;
	}

	public Rectangle2D getRectOfThisTerminal() {
		return rectOfThisTerminal;
	}

	public void setRectOfThisTerminal(Rectangle2D rectOfThisTerminal) {
		this.rectOfThisTerminal = rectOfThisTerminal;
	}	
	
	

}
