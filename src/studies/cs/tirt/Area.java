package studies.cs.tirt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Area {

	private float areaLengthX = 1000F;
	private float areaLengthY = 700F;

	private TreeSet<BaseTransceiverStation> baseStations = new TreeSet<BaseTransceiverStation>();
	private TreeSet<Terminal> terminals = new TreeSet<Terminal>();

	private Set<Terminal> allocatedTerminals = new TreeSet<Terminal>();

	private Random rand = new Random(13);
	private Random rand2 = new Random(23);
	
	private int colorIndex = 0;

	public Area() {
	}

	public Area(TreeSet<BaseTransceiverStation> baseStations,
			TreeSet<Terminal> terminals) {
		this.baseStations = baseStations;
		this.terminals = terminals;
	}

	public void arrangeBTS() {
		arrangeNBaseStations(463, 347, 230, 15);
		for (BaseTransceiverStation bts : baseStations) {
			bts.setColor(Colors.getColor(colorIndex++));
		}
	}

	public void arrangeTerminals() {
		// arangeNTerminalsInAreaCircle(443, 340, 200, 200);
		// arangeNTerminalsInSquareArea(443, 340, 250, 250);
		arangeNTerminalsInSquareArea(443, 340, 250, 300);
	}

	private void arrangeNBaseStations(float x, float y, float radius, int N) {
		int addedElements = 0;
		while (addedElements < N) {
			float bsX = x + (randomSign() * rand.nextFloat() * radius);
			float bsY = y + (randomSign() * rand.nextFloat() * radius);
			if (isPointInArea(bsX, bsY)) {
				baseStations.add(new BaseTransceiverStation(bsX, bsY));
				addedElements++;
			}
		}
	}

	private void arangeNTerminalsInSquareArea(float x, float y, float radius,
			int N) {
		int addedElements = 0;
		while (addedElements < N) {
			float terminalX = x + (randomSign() * rand.nextFloat() * radius);
			float terminalY = y + (randomSign() * rand.nextFloat() * radius);
			if (isPointInArea(terminalX, terminalY)) {
				terminals.add(new Terminal(terminalX, terminalY));
				addedElements++;
			}
		}
	}

	private void arangeNTerminalsInCircleArea(float x, float y, float radius,
			int N) {
		int i = 0;
		int addedElements = 0;
		while (addedElements < N) {
			float terminalX = x + (randomSign() * rand.nextFloat() * radius);
			float terminalY = y
					+ (randomSign() * rand.nextFloat() * (float) Math.sqrt(Math
							.pow(radius, 2) - Math.pow(terminalX - x, 2)));
			/*
			 * normalization value (it couldn't be bigger than this radical) to
			 * get a circle *
			 */
			if (isPointInArea(terminalX, terminalY)) {
				terminals.add(new Terminal(terminalX, terminalY));
				addedElements++;
			}
		}
	}

	private float randomSign() {
		return ((rand.nextInt() % 2) == 0) ? 1.0F : -1.0F;
	}

	private boolean isPointInArea(float x, float y) {
		return (x >= 0.0F) && (x <= areaLengthX) && (y >= 0.0F)
				&& (y <= areaLengthY);
	}

	public Set<BaseTransceiverStation> getBaseStations() {
		return baseStations;
	}

	public Set<Terminal> getTerminals() {
		return terminals;
	}

	/* this two methods should be used only to run tests */
	void setBaseStations(TreeSet<BaseTransceiverStation> baseStations) {
		this.baseStations = baseStations;
	}

	void setTerminals(TreeSet<Terminal> terminals) {
		this.terminals = terminals;
	}

	/* end of tests methods */

	void searchBTSsInRangeOfTerminals() {
		for (Terminal t : terminals) {
			for (BaseTransceiverStation bts : baseStations) {
				if (Point.calculateDistanceBetweenTwoPoints(
						t.getTerminalPosition(), bts.getBtsPosition()) <= bts
						.getSignalStrength()) {
					bts.getTerminalsInRange().add(t);
					t.getBTSInRange().add(bts);
				}
			}
		}
	}

	public int countTerminalsAutOfRange() {
		int numberOfTerminalsAutOfRange = 0;
		for (Terminal t : terminals) {
			if (t.getBTSInRange().isEmpty())
				numberOfTerminalsAutOfRange++;
		}

		return numberOfTerminalsAutOfRange;
	}

	public int countTerminalsInRange() {
		int numberOfTerminalsInRange = 0;
		for (Terminal t : terminals) {
			if (!t.getBTSInRange().isEmpty())
				numberOfTerminalsInRange++;
		}

		return numberOfTerminalsInRange;
	}

	// it will allocate max number of nearby terminals for each Base Station
	void bruteAllocationNeardestUpLeftCorner() {
		for (BaseTransceiverStation currentBts : baseStations) {
			allocateMaxNumberTerminalsInRangeNeardestUpLeftCorner(currentBts);
		}
	}

	private void allocateMaxNumberTerminalsInRangeNeardestUpLeftCorner(
			BaseTransceiverStation currentBts) {

		Terminal tmpTerminal;
		Object[] terminalsInRange = currentBts.getTerminalsInRange().toArray();

		int index = 0;
		int numberOfCopiedTerminals = 0;

		while (index < terminalsInRange.length
				&& numberOfCopiedTerminals < currentBts
						.getNumberAllowedTerminals()) {

			tmpTerminal = (Terminal) terminalsInRange[index];
			if (!allocatedTerminals.contains(tmpTerminal)) {
				currentBts.connectTerminal(tmpTerminal);
				tmpTerminal.setAllocatedBts(currentBts);
				allocatedTerminals.add(tmpTerminal);
				numberOfCopiedTerminals++;
			}

			index++;
		}
	}

	void allocateMaxNumberOfTerminalsNeardestBTS() {
		for (BaseTransceiverStation currentBts : baseStations) {
			Terminal tmpTerminal;
			Terminal[] sortedTerminalsInRange = sortTerminalsFromNeardestToBTS(
					currentBts.getTerminalsInRange(), currentBts);

			int index = 0;
			int numberOfCopiedTerminals = 0;

			while (index < sortedTerminalsInRange.length
					&& numberOfCopiedTerminals < currentBts
							.getNumberAllowedTerminals()) {

				tmpTerminal = (Terminal) sortedTerminalsInRange[index];
				if (!allocatedTerminals.contains(tmpTerminal)) {
					currentBts.connectTerminal(tmpTerminal);
					tmpTerminal.setAllocatedBts(currentBts);
					allocatedTerminals.add(tmpTerminal);
					numberOfCopiedTerminals++;
				}

				index++;
			}
		}
	}

	private Terminal[] sortTerminalsFromNeardestToBTS(
			SortedSet<Terminal> terminalsInRange, BaseTransceiverStation bts) {
		Terminal[] sortedTerminals = new Terminal[terminalsInRange.size()];

		/* rewrite terminals to array */
		int index = 0;
		for (Terminal t : terminalsInRange) {
			sortedTerminals[index] = t;
			index++;
		}

		float dist1, dist2;
		Terminal tmp;
		for (int i = 1; i < sortedTerminals.length; i++) {
			for (int j = sortedTerminals.length - 1; j >= i; j--) {
				dist1 = bts.distanceBtwBTSandTerminal(sortedTerminals[j]);
				dist2 = bts.distanceBtwBTSandTerminal(sortedTerminals[j - 1]);
				if (dist1 < dist2) {
					tmp = sortedTerminals[j - 1];
					sortedTerminals[j - 1] = sortedTerminals[j];
					sortedTerminals[j] = tmp;
				}
			}
		}
		return sortedTerminals;
	}

	private BaseTransceiverStation chooseBTSWithTheWeaknesSignalStrengthInRangeOfBTS(
			Terminal t) {
		BaseTransceiverStation[] sortedBTS = new BaseTransceiverStation[t
				.getBTSInRange().size()];

		/* rewrite bts to array */
		int index = 0;
		for (BaseTransceiverStation bts : t.getBTSInRange()) {
			sortedBTS[index] = bts;
			index++;
		}

		float sig1, sig2;
		BaseTransceiverStation tmp;
		for (int i = 1; i < sortedBTS.length; i++) {
			for (int j = sortedBTS.length - 1; j >= i; j--) {
				sig1 = sortedBTS[j].getSignalStrength();
				sig2 = sortedBTS[j - 1].getSignalStrength();
				if (sig1 < sig2) {
					tmp = sortedBTS[j - 1];
					sortedBTS[j - 1] = sortedBTS[j];
					sortedBTS[j] = tmp;
				}
			}
		}

		/*index = 0;
		while (index<sortedBTS.length && sortedBTS[index].getConnectedTerminals().size() >= sortedBTS[index]
				.getNumberAllowedTerminals())
			index++;

		return (index < sortedBTS.length) ? sortedBTS[index] : null;*/
		for (BaseTransceiverStation bts : sortedBTS) {
			if (bts.getConnectedTerminals().size()<bts.getNumberAllowedTerminals())
				return bts;
		}
		
		return null;
	}

	void allocateTerminalsFirstTerminalsNeardestAndInRangeOfOnlyOneBTS() {
		for (BaseTransceiverStation currentBts : baseStations) {
			Terminal tmpTerminal;
			Terminal[] sortedTerminalsInRange = sortTerminalsFromNeardestToBTS(
					currentBts.getTerminalsInRange(), currentBts);

			int index = 0;
			int numberOfCopiedTerminals = 0;

			while (index < sortedTerminalsInRange.length
					&& numberOfCopiedTerminals < currentBts
							.getNumberAllowedTerminals()) {

				tmpTerminal = (Terminal) sortedTerminalsInRange[index];
				if (!allocatedTerminals.contains(tmpTerminal)
						&& tmpTerminal.getBTSInRange().size() == 1) {
					currentBts.connectTerminal(tmpTerminal);
					tmpTerminal.setAllocatedBts(currentBts);
					allocatedTerminals.add(tmpTerminal);
					numberOfCopiedTerminals++;
				}

				index++;
			}			
		}
		
		BaseTransceiverStation btsToAllocate;
		for (Terminal t : terminals) {
			if (t.getBTSInRange().size() != 0
					&& t.getAllocatedBts() == null) {
				btsToAllocate = chooseBTSWithTheWeaknesSignalStrengthInRangeOfBTS(t);
				if (btsToAllocate!=null){					
					btsToAllocate.connectTerminal(t);
					t.setAllocatedBts(btsToAllocate);
					allocatedTerminals.add(t);
				}					
			}
		}
	}
	
	
	void allocateRandomizedTerminals(){
		for (BaseTransceiverStation currentBts : baseStations) {
			Terminal tmpTerminal;
			Terminal[] sortedTerminalsInRange = sortTerminalsFromNeardestToBTS(
					currentBts.getTerminalsInRange(), currentBts);

			int tmpIndex;
			int counter=0;
			int valueAtIndex;
			int numberOfCopiedTerminals = 0;

			List<Integer> notUsedValues = new LinkedList<Integer>();
			for (int i = 0; i < sortedTerminalsInRange.length; i++) {
				notUsedValues.add((Integer) i);
			}
			
			while (counter < sortedTerminalsInRange.length
					&& numberOfCopiedTerminals < currentBts
							.getNumberAllowedTerminals()) {
				
				
				tmpIndex = (int) (rand2.nextFloat()*notUsedValues.size());	//random index from range				
				valueAtIndex = notUsedValues.remove(tmpIndex);
				/*notUsedValues..remove((Integer) index);*/
				/*do {
					index = (int) (rand2.nextFloat()*sortedTerminalsInRange.length);	//random index from range 
				} while (usedIndexes.contains(index));	// random until get not used index
*/
				tmpTerminal = (Terminal) sortedTerminalsInRange[valueAtIndex];
				if (!allocatedTerminals.contains(tmpTerminal)) {
					currentBts.connectTerminal(tmpTerminal);
					tmpTerminal.setAllocatedBts(currentBts);
					allocatedTerminals.add(tmpTerminal);					
					numberOfCopiedTerminals++;				
				}

				counter++;
			}
		}
	}
	
	public int countAllocatedTerminals(){
		int sum = 0;
		for (BaseTransceiverStation bts : baseStations) {
			sum+= bts.getConnectedTerminals().size();
		}
		return sum;
	}
	
	public void restoreTerminalsAndBtsToStartPoint() {
		for (Terminal t : terminals) {
			t.setAllocatedBts(null);			
		}
		
		for (BaseTransceiverStation bts : baseStations) {
			bts.setConnectedTerminals(new ArrayList<Terminal>());
		}		
	}

	public void setRandom(Random random) {
		rand= random;		
	}

	public int countMaximalNumberOfTerminalsPossibleToAllocate() {
		int sum = 0;
		for (BaseTransceiverStation bts : baseStations) {
			sum+= Math.min(bts.getTerminalsInRange().size(), bts.getNumberAllowedTerminals());
		}
		return sum;
	}

	public float countQualityOfAllocation() {
		return ((float) countAllocatedTerminals())/countMaximalNumberOfTerminalsPossibleToAllocate();
	}

	public float countPercentOfAllocation() {
		float sum = 0;
		for (BaseTransceiverStation bts : baseStations) {
			for (Terminal t : bts.getConnectedTerminals()) {
				sum+= Point.calculateDistanceBetweenTwoPoints(bts.getBtsPosition(), t.getTerminalPosition());
			}
			sum/= countAllocatedTerminals();
		}
		return sum;
	}
	
	
		

}
