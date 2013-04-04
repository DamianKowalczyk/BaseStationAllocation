package studies.cs.tirt;

public class Terminal implements Comparable<Terminal> {
	
	private float x;
	private float y;
	
	private BaseTransceiverStation bts = null;
	
	public Terminal(float x, float y){
		this.x = x;
		this.y = y;
	}

	public Terminal(float x, float y, BaseTransceiverStation bts) {
		this(x,y);
		this.bts = bts;
	}
	
	public boolean equals(Object o) {
		return (o instanceof Terminal) && 
				(x == ((Terminal) o).getX() && y == ((Terminal) o).getY());	// two  terminals are equal when are in the same place	
	}

	
/* ********** getters and setters ****************	*/
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public BaseTransceiverStation getBts() {
		return bts;
	}

	public void setBts(BaseTransceiverStation bts) {
		this.bts = bts;
	}	

	@Override
	public int compareTo(Terminal o) {
		double distThis = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		double distO = Math.sqrt(Math.pow(o.getX(), 2)+Math.pow(o.getY(), 2));
		
		return distThis>distO ? 1 : (distThis==distO ? 0 : -1);
	}

}
