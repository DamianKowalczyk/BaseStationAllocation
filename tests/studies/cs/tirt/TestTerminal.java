package studies.cs.tirt;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTerminal {
	
	@Test
	public void shouldInformThatTwoTerminalsAreDifferentWhenOnlyXAxisIsDifferent() {
		// given
		Terminal t1 = new Terminal(0.1F, 0.0F);
		Terminal t2 = new Terminal(0.0F, 0.0F);
		// when
		boolean result = t1.equals(t2);
		// then
		assertThat(result).isFalse();
	}
	
	@Test
	public void shouldInformThatTwoTerminalsAreDifferentWhenOnlyYAxisIsDifferent() {
		// given
		Terminal t1 = new Terminal(0.1F, 0.1F);
		Terminal t2 = new Terminal(0.0F, 0.0F);
		// when
		boolean result = t1.equals(t2);
		// then
		assertThat(result).isFalse();
	}
	
	@Test
	public void shouldInformThatTwoTerminalsAreDifferentWhenXAdnYAxisAreDifferent() {
		// given
		Terminal t1 = new Terminal(0.1F, 0.0F);
		Terminal t2 = new Terminal(0.0F, 0.0F);
		// when
		boolean result = t1.equals(t2);
		// then
		assertThat(result).isFalse();
	}
	
	@Test
	public void shouldInformThatTwoTerminalsAreSame() {
		// given
		Terminal t1 = new Terminal(0.1F, 0.1F);
		Terminal t2 = new Terminal(0.1F, 0.1F);
		// when
		boolean result = t1.equals(t2);
		// then
		assertThat(result).isTrue();
	}
	
	@Test
	public void shouldInformThatTwoTerminalsAreSameForTwoZerosPoint() {
		// given
		Terminal t1 = new Terminal(0.0F, 0.0F);
		Terminal t2 = new Terminal(0.0F, 0.0F);
		// when
		boolean result = t1.equals(t2);
		// then
		assertThat(result).isTrue();
	}
	
	@Test
	public void shouldCompareTwoSameTerminalsInTheSameZerosPosition() {
		// given
		Terminal t1 = new Terminal(0.0F, 0.0F);
		Terminal t2 = new Terminal(0.0F, 0.0F);
		// when
		int result = t1.compareTo(t2);
		// then
		assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void shouldInformThatFirstTerminalIsLessThanSecond() {
		// given
		Terminal t1 = new Terminal(0.0F, 0.0F);
		Terminal t2 = new Terminal(4.0F, 5.0F);
		// when
		int result = t1.compareTo(t2);
		// then
		assertThat(result).isEqualTo(-1);
	}

	@Test
	public void shouldInformThatFirstTerminalIsGreaterThanSecond() {
		// given
		Terminal t1 = new Terminal(5.0F, 4.0F);
		Terminal t2 = new Terminal(0.0F, 0.0F);
		// when
		int result = t1.compareTo(t2);
		// then
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	public void shouldInformThatFirstTerminalIsGreaterThanSecondForSmallerDifferent() {
		// given
		Terminal t1 = new Terminal(5.1F, 4.0F);
		Terminal t2 = new Terminal(5.0F, 4.0F);
		// when
		int result = t1.compareTo(t2);
		// then
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	public void shouldInformThatFirstTerminalIsGreaterThanSecondForXAxisDifferentOnly() {
		// given
		Terminal t1 = new Terminal(5.1F, 4.0F);
		Terminal t2 = new Terminal(0.0F, 4.0F);
		// when
		int result = t1.compareTo(t2);
		// then
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void shouldInformThatFirstTerminalIsGreaterThanSecondForYAxisDifferentOnly() {
		// given
		Terminal t1 = new Terminal(5.1F, 4.0F);
		Terminal t2 = new Terminal(5.1F, 2.0F);
		// when
		int result = t1.compareTo(t2);
		// then
		assertThat(result).isEqualTo(1);
	}
}
