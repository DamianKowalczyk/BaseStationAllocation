package studies.cs.tirt;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestArea {
	
	private Area area;
	private TreeSet<BaseTransceiverStation> baseStations;
	private TreeSet<Terminal> terminals;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {		
		baseStations = new TreeSet<BaseTransceiverStation>();
		terminals = new TreeSet<Terminal>();		
	}

	@After
	public void tearDown() throws Exception {
	}

		
	@Test
	public void shouldSetOneTerminalInRangeOfBTSAndOneBTSinTerminalsRange() {
		// given
		allocateOneBTSAndOneTerminalInItsRangeOnArea();		
		// when
		area.searchBTSsInRangeOfTerminals();
		boolean result = area.getBaseStations().iterator().next().getTerminalsInRange().iterator().next().equals(terminals.iterator().next());
		// then
		assertThat(result).isTrue();
	}
	
		
	@Test
	public void shoulCountZeroTerminalOutOfRangeOfBTS() {
		// given				
		allocateOneBTSAndOneTerminalInItsRangeOnArea();		
		// when
		area.searchBTSsInRangeOfTerminals();		
		int result = area.countTerminalsAutOfRange();
		
		// then
		assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void shoulCountOneTerminalInRangeOfBTS() {
		// given				
		allocateOneBTSAndOneTerminalInItsRangeOnArea();		
		// when
		area.searchBTSsInRangeOfTerminals();		
		int result = area.countTerminalsInRange();
		
		// then
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	public void shoulCountTwoTerminalsInRangeOfBTSWhenTheyAreOnBorderOfBTSRange() {
		// given				
		allocateTwoBTSInBorderOfBTS();		
		// when
		area.searchBTSsInRangeOfTerminals();		
		int result = area.countTerminalsInRange();
		
		// then
		assertThat(result).isEqualTo(2);
	}
	
	/*brute allocation*/
	@Test
	public void shoulAllocateOneTerminalToForBruteAlgorithm() {
		// given				
		allocateOneBTSAndOneTerminalInItsRangeOnArea();		
		// when
		area.searchBTSsInRangeOfTerminals();
		area.bruteAllocationNeardestUpLeftCorner();
		BaseTransceiverStation result = area.getTerminals().iterator().next().getAllocatedBts();
		
		// then
		BaseTransceiverStation addedBts = baseStations.iterator().next();
		assertThat(result).isEqualTo(addedBts);
	}
	
	/*@Test
	public void shouldAllocateFiveTerminalsForBruteAlgorithm() {
		// given				
		allocateSixTerminalsInRangeOfBTS();		
		// when
		area.searchBTSsInRangeOfTerminals();
		area.bruteAllocation();
		Set<BaseTransceiverStation> allocatedBaseStations;
		allocatedBaseStations = area.getTerminals().iterator().next().getAllocatedBts();
		
		// then
		BaseTransceiverStation addedBts = baseStations.iterator().next();
		assertThat(result).isEqualTo(addedBts);
	}*/
	
	
	/*helper methods*/
	private void allocateOneBTSAndOneTerminalInItsRangeOnArea(){
		BaseTransceiverStation b = new BaseTransceiverStation(50,50,20, 5);
		baseStations.add(b);
		
		Terminal t = new Terminal(51, 45);
		terminals.add(t);
		
		area = new Area(baseStations, terminals);
	}
	
	private void allocateTwoBTSInBorderOfBTS(){
		BaseTransceiverStation b = new BaseTransceiverStation(50,50,20, 5);
		baseStations.add(b);
		
		Terminal t1 = new Terminal(50, 30);
		Terminal t2 = new Terminal(50, 70);
		terminals.add(t1);
		terminals.add(t2);
		
		area = new Area(baseStations, terminals);
	}
	
	private void allocateSixTerminalsInRangeOfBTS(){
		BaseTransceiverStation b = new BaseTransceiverStation(50,50,20, 5);
		baseStations.add(b);
		
		Terminal t1 = new Terminal(50, 41);
		Terminal t2 = new Terminal(50, 42);
		Terminal t3 = new Terminal(50, 43);
		Terminal t4 = new Terminal(50, 44);
		Terminal t5 = new Terminal(50, 45);
		Terminal t6 = new Terminal(50, 46);
		terminals.add(t1);
		terminals.add(t2);
		terminals.add(t3);
		terminals.add(t4);
		terminals.add(t5);
		terminals.add(t6);
		
		area = new Area(baseStations, terminals);
	}

}
