package studies.cs.tirt;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.fest.assertions.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPoint {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldInformThatTwoPointsAreDifferent() {
		// given
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1, 1);
		// when
		boolean result = p1.equals(p2);
		// then
		assertThat(result).isFalse();
	}

	@Test
	public void shouldInformThatTwoPointsAreSame() {
		// given
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 1);
		// when
		boolean result = p1.equals(p2);
		// then
		assertThat(result).isTrue();
	}

	@Test
	public void shouldInformThatTwoZerosPointsAreSame() {
		// given
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		// when
		boolean result = p1.equals(p2);
		// then
		assertThat(result).isTrue();
	}

	@Test
	public void shouldInformThatTwoZerosFloatPointsAreSame() {
		// given
		float zerosFloat = 0.0F;
		Point p1 = new Point(zerosFloat, zerosFloat);
		Point p2 = new Point(zerosFloat, zerosFloat);
		// when
		boolean result = p1.equals(p2);
		// then
		assertThat(result).isTrue();
	}
	
	@Test
	public void shouldInformThatTwoPointsAreEquals(){
		// given
		Point p1 = new Point(0.0F, 0.0F);
		Point p2 = new Point(0.0F, 0.0F);
		// when
		int result = p1.compareTo(p2);
		// then
		assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void shouldInformThatFirstPointIsGreater(){
		// given
		Point p1 = new Point(0.1F, 0.1F);
		Point p2 = new Point(0.0F, 0.0F);
		// when
		int result = p1.compareTo(p2);
		// then
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	public void shouldInformThatFirstPointIsLower(){
		// given
		Point p1 = new Point(0.0F, 0.0F);
		Point p2 = new Point(0.0F, 0.1F);
		// when
		int result = p1.compareTo(p2);
		// then
		assertThat(result).isEqualTo(-1);
	}
	
	@Test
	public void shouldCalculateDistanceBtwTwoPointsEquals1(){
		// given
		Point p1 = new Point(1.0F, 0.0F);
		Point p2 = new Point(0.0F, 0.0F);
		// when
		float result = Point.calculateDistanceBetweenTwoPoints(p1, p2);
		// then
		assertThat(result).isEqualTo(1.0F);
	}
	
	@Test
	public void shouldCalculateDistanceBtwTwoPointsEquals0(){
		// given
		Point p1 = new Point(0.0F, 0.0F);
		Point p2 = new Point(0.0F, 0.0F);
		// when
		float result = Point.calculateDistanceBetweenTwoPoints(p1, p2);
		// then
		assertThat(result).isEqualTo(0.0F);
	}
	
	@Test
	public void shouldCalculateDistanceBtwTwoPointsEqualsSqrt8(){
		// given
		Point p1 = new Point(0.0F, 0.0F);
		Point p2 = new Point(2.0F, 2.0F);
		// when
		float result = Point.calculateDistanceBetweenTwoPoints(p1, p2);
		// then
		assertThat(result).isEqualTo((float) Math.sqrt(8));
	}
	
	@Test
	public void shouldCalculateDistanceBtwTwoPointsDifferenceOnlyOnXAxis(){
		// given
		Point p1 = new Point(0.0F, 0.0F);
		Point p2 = new Point(2.0F, 0.0F);
		// when
		float result = Point.calculateDistanceBetweenTwoPoints(p1, p2);
		// then
		assertThat(result).isEqualTo(2);
	}
	
	@Test
	public void shouldCalculateDistanceBtwTwoPointsDifferenceOnlyOnYAxis(){
		// given
		Point p1 = new Point(0.0F, 0.0F);
		Point p2 = new Point(0.0F, 2.0F);
		// when
		float result = Point.calculateDistanceBetweenTwoPoints(p1, p2);
		// then
		assertThat(result).isEqualTo(2);
	}
	

}
