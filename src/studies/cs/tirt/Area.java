/*package studies.cs.tirt;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Area extends JComponent{
	
	private static float areaLengthX = 1500F;
	private static float areaLengthY = 1000F;
	
	private static Set<BaseTransceiverStation> baseStations = new TreeSet<BaseTransceiverStation>();
	private static Set<Terminal> terminals = new TreeSet<Terminal>();	
	
	private Random rand = new Random(47);
	
	public Area() {
		arrangeTerminals();
		arrangeBTS();
	}
	
	public Area(float areaLengthX, float areaLengthY) {
		this();
		this.areaLengthX = areaLengthX;
		this.areaLengthY = areaLengthY;
	}
	
	public void arrangeBTS(){
		arrangeNBaseStations(300, 350, 350, 15);
	}
	
	public void arrangeTerminals(){
		arangeNTerminalsInAreaCircle(200, 100, 100, 200);
		arangeNTerminalsInAreaCircle(500, 120, 150, 350);
		
		arangeNTerminalsInAreaSquare(200, 450, 100, 100);
		arangeNTerminalsInAreaSquare(500, 500, 150, 200);
	}	
	
	private void arrangeNBaseStations(float x, float y, float radius, int N){
		int addedElements = 0;
		while(addedElements<N) {			
			float bsX = x + (randomSign()* rand.nextFloat() * radius);
			float bsY = y + (randomSign()* rand.nextFloat() * radius);
			if (correctPosition(bsX, bsY)){
				baseStations.add(new BaseTransceiverStation(bsX, bsY, 50,50));
				addedElements++;
			}
		}
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
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
				
		for (Terminal t : terminals) {
			g2.draw(new Rectangle2D.Float(t.getX(), t.getY(), 3,3));
		}
		
		g2.setPaint(Color.RED);
		for (BaseTransceiverStation b : baseStations) {			
			g2.draw(new Rectangle2D.Float(b.getX(), b.getY(), 5,10));
		}
		Rectangle2D rect = new Rectangle2D.Float(100F, 100F, 10, 10);
		g2.draw(rect);		
	}	
}*/