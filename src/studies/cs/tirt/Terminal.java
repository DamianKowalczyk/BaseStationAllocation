package studies.cs.tirt;

public class Terminal {
	
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

}
