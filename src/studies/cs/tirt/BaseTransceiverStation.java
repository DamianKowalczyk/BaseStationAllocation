package studies.cs.tirt;

public class BaseTransceiverStation {
	
	private int x;
	private int y;
	
	private int signalStrength;
	private int numberAllowedTerminals;
	
	
	public BaseTransceiverStation(int x, int y, int signalStrength,
			int numberAllowedTerminals) {
		super();
		this.x = x;
		this.y = y;
		this.signalStrength = signalStrength;
		this.numberAllowedTerminals = numberAllowedTerminals;
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
	public int getSignalStrength() {
		return signalStrength;
	}
	public void setSignalStrength(int signalStrength) {
		this.signalStrength = signalStrength;
	}
	public int getNumberAllowedTerminals() {
		return numberAllowedTerminals;
	}
	public void setNumberAllowedTerminals(int numberAllowedTerminals) {
		this.numberAllowedTerminals = numberAllowedTerminals;
	}
	
	

}
