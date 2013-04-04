package studies.cs.tirt;

public class BaseTransceiverStation implements Comparable<BaseTransceiverStation> {
	
	private float x;
	private float y;
	
	private float signalStrength;
	private int numberAllowedTerminals;
	
	
	public BaseTransceiverStation(float x, float y, float signalStrength,
			int numberAllowedTerminals) {
		super();
		this.x = x;
		this.y = y;
		this.signalStrength = signalStrength;
		this.numberAllowedTerminals = numberAllowedTerminals;
	}
	
	public boolean equals(Object o){
		return (o instanceof BaseTransceiverStation) && 
				(x == ((BaseTransceiverStation) o).getX() && y == ((BaseTransceiverStation) o).getY());	// two  base stations are equal when are in the same place	
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

	public float getSignalStrength() {
		return signalStrength;
	}

	public void setSignalStrength(float signalStrength) {
		this.signalStrength = signalStrength;
	}

	public int getNumberAllowedTerminals() {
		return numberAllowedTerminals;
	}

	public void setNumberAllowedTerminals(int numberAllowedTerminals) {
		this.numberAllowedTerminals = numberAllowedTerminals;
	}	
	
	@Override
	public int compareTo(BaseTransceiverStation o) {
		double distThis = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		double distO = Math.sqrt(Math.pow(o.getX(), 2)+Math.pow(o.getY(), 2));
		
		return distThis>distO ? 1 : (distThis==distO ? 0 : -1);
	}

}
