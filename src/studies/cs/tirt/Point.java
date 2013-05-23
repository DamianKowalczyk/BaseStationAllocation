package studies.cs.tirt;

public class Point implements Comparable<Point> {

	private float x;
	private float y;

	public Point(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean equals(Point p) {
		return (p instanceof Point) && (x == p.getX() && y == p.getY());
	}

	@Override
	public int compareTo(Point p) {
		double distThis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double distO = Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));

		return distThis > distO ? 1 : (distThis == distO ? 0 : -1);
	}
	
	public static float calculateDistanceBetweenTwoPoints(Point point1, Point point2) {		
		return (float) Math.sqrt(Math.pow(point1.getX()-point2.getX(), 2) + Math.pow(point2.getY()-point2.getY(), 2)); 
	}

}
