package studies.cs.tirt;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Terminal implements Comparable<Terminal> {
	
	private Point terminalPosition;
	
	private BaseTransceiverStation allocatedBts = null;
	private ArrayList<BaseTransceiverStation> btsInRange = new ArrayList<BaseTransceiverStation>();
	
	private Rectangle2D graphicalRectOfThisTerminal;

	public Terminal(float x, float y) {		
		terminalPosition = new Point(x, y); 
	}

	public boolean equals(Object o) {
		return (o instanceof Terminal)
				&& (terminalPosition.equals(((Terminal) o).getTerminalPosition()));		
	}

	@Override
	public int compareTo(Terminal t) {
		return getTerminalPosition().compareTo(t.getTerminalPosition());
	}	

	public BaseTransceiverStation getAllocatedBts() {
		return allocatedBts;
	}

	public void setAllocatedBts(BaseTransceiverStation bts) {
		this.allocatedBts = bts;
	}

	public ArrayList<BaseTransceiverStation> getBTSInRange() {
		return btsInRange;
	}

	public Rectangle2D getGraphicalRectOfThisTerminal() {
		return graphicalRectOfThisTerminal;
	}

	public void setGraphicalRectOfThisTerminal(Rectangle2D rectOfThisTerminal) {
		this.graphicalRectOfThisTerminal = rectOfThisTerminal;
	}	
	
	public Point getTerminalPosition() {
		return terminalPosition;
	}

}
