package studies.cs.tirt;

public class Honeycomb {
	
	//this fields hold value of difference between two points
	private float deltaX;
	private float deltaY;
	
		
	public float[][] createHoneycomb(float x, float y, float d) {
		float[][] coordinates = new float[6][2];
		
		deltaX = d * 0.5f; // d*sin30 
		deltaY = (float) ((d * Math.sqrt(3))/2); // d*cos30
		
		coordinates[0][0] = x;
		coordinates[0][1] = y;		
		coordinates[1][0] = x+d;
		coordinates[1][1] = y;
		coordinates[2][0] = x+d+deltaX;
		coordinates[2][1] = y-deltaY;
		coordinates[3][0] = x+d;
		coordinates[3][1] = y-2*deltaY;
		coordinates[4][0] = x;
		coordinates[4][1] = y-2*deltaY;
		coordinates[5][0] = x-deltaX;
		coordinates[5][1] = y-deltaY;
		
		return coordinates; 
	}
}
