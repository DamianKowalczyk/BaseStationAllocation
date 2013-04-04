package studies.cs.tirt;
import java.util.*;

import javax.swing.JFrame;

public class Area {
	
	private static float areaLengthX = 1500F;
	private static float areaLengthY = 1000F;
	
	private Set<BaseTransceiverStation> baseStations = new TreeSet<BaseTransceiverStation>();
	private Set<Terminal> terminals = new TreeSet<Terminal>();	
	
	private Random rand = new Random(47);
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicalArea graphArea = new GraphicalArea(areaLengthX, areaLengthY);
		graphArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphArea.setVisible(true);

	}
	
	public void arrangeBTS(){
		
	}
	
	public void arrangeTerminals(){
		
	}
	
	/*x and y are the coordinates of one this base stations and distance determines the distance determines site length of hexagon*/
	private void addBaseStationsOnHoneycomb(float x, float y, float distance) {
		baseStations.add(new BaseTransceiverStation(x, y, distance, 20));
		baseStations.add(new BaseTransceiverStation(x+distance, y, distance, 20));
		
	}
	
	//
	private void arangeNTerminalsInArea(float x, float y, float radius, int N) {
		int addedElements = 0;
		while(addedElements<N) {			
			float terminalX = x + (randomSign()* rand.nextFloat() * radius);
			float terminalY = y + (randomSign()* rand.nextFloat() * radius);
			if (correctPosition(terminalX, terminalY)){
				terminals.add(new Terminal(terminalX, terminalY));
				addedElements++;
			}
		}		
	}
	
	private float randomSign(){
		return ((rand.nextInt() % 2) == 0)? 1.0F : -1.0F;	
	}
	
	private boolean correctPosition(float x, float y) {		
		return (x >= 0.0F) && (x <= areaLengthX) &&
				(y >= 0.0F) && (y <= areaLengthY);
	}
	 

}


class GraphicalArea extends JFrame {
	 
	public GraphicalArea(float areaLengthX, float areaLengthY){
		setSize((int) areaLengthX, (int) areaLengthY);	// create graphical area 
	}
	
}