package studies.cs.tirt;

public class Terminal {
	
	private int x;
	private int y;
	
	private BaseTransceiverStation bts = null;
	
	

	public Terminal(int x, int y, BaseTransceiverStation bts) {
		super();
		this.x = x;
		this.y = y;
		this.bts = bts;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BaseTransceiverStation getBts() {
		return bts;
	}

	public void setBts(BaseTransceiverStation bts) {
		this.bts = bts;
	}
	
	
	
	

}
