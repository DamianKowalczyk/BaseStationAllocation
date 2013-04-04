package studies.cs.tirt;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Area {
	
	private static float areaLengthX = 1500F;
	private static float areaLengthY = 1000F;
	
	private static Set<BaseTransceiverStation> baseStations = new TreeSet<BaseTransceiverStation>();
	private static Set<Terminal> terminals = new TreeSet<Terminal>();	
	
	private Random rand = new Random(47);
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Area area = new Area();
		area.arrangeTerminals();
		
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GraphicalArea graphArea = new GraphicalArea(areaLengthX, areaLengthY, baseStations, terminals);
				graphArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				graphArea.setVisible(true);
			}
		});
	}
	
	public void arrangeBTS(){
		
	}
	
	public void arrangeTerminals(){
		arangeNTerminalsInAreaCircle(200, 200, 100, 200);
		arangeNTerminalsInAreaCircle(500, 400, 150, 350);
		
		arangeNTerminalsInAreaSquare(200, 800, 100, 100);
		arangeNTerminalsInAreaSquare(500, 700, 150, 200);
	}
	
	/*x and y are the coordinates of one this base stations and distance determines the distance determines site length of hexagon*/
	/*private void addBaseStationsOnHoneycomb(float x, float y, float distance) {
		baseStations.add(new BaseTransceiverStation(x, y, distance, 20));
		baseStations.add(new BaseTransceiverStation(x+distance, y, distance, 20));		
	}*/
	
	private void arrangeOneBaseStations(){
		
	}
	
	//
	private void arangeNTerminalsInAreaSquare(float x, float y, float radius, int N) {
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
	
	private void arangeNTerminalsInAreaCircle(float x, float y, float radius, int N) {
		int i = 0;
		int addedElements = 0;
		while(addedElements<N) {			
			float terminalX = x + (randomSign()* rand.nextFloat() * radius);				
			float terminalY = y +  (randomSign() * rand.nextFloat() * 
					(float) Math.sqrt(Math.pow(radius, 2)-Math.pow(terminalX-x, 2))); // normalization y value (it couldn't be bigger than this radical) to get a circle
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

	public Set<BaseTransceiverStation> getBaseStations() {
		return baseStations;
	}

	public Set<Terminal> getTerminals() {
		return terminals;
	}
}


class GraphicalArea extends JFrame {
	 
	public GraphicalArea(float areaLengthX, float areaLengthY){
		setSize((int) areaLengthX, (int) areaLengthY);	// create graphical area		
	}	
	
	public GraphicalArea(float areaLengthX, float areaLengthY, Set<BaseTransceiverStation> baseStations,
			Set<Terminal> terminals){
		
		this(areaLengthX, areaLengthY);
		add(new GraphicalComponents(baseStations, terminals));
	}
	 
}

class GraphicalComponents extends JComponent {
	
	private Set<BaseTransceiverStation> baseStations;
	private Set<Terminal> terminals;
	
	
	public GraphicalComponents(Set<BaseTransceiverStation> baseStations,
			Set<Terminal> terminals) {
		super();
		this.baseStations = baseStations;
		this.terminals = terminals;
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		for (Terminal t : terminals) {
			g2.draw(new Rectangle2D.Float(t.getX(), t.getY(), 3,3));
		}
		/*Rectangle2D rect = new Rectangle2D.Float(100F, 100F, 10, 10);
		g2.draw(rect);	*/	
	}
}