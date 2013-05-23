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
	public int compareTo(Point o) {
		double distThis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double distO = Math.sqrt(Math.pow(o.getX(), 2) + Math.pow(o.getY(), 2));

		return distThis > distO ? 1 : (distThis == distO ? 0 : -1);
	}

}
