package studies.cs.tirt;

import java.awt.Color;

public class Colors {
	private static Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW};
	/*withNormalGreyColourANDRED private static Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};*/
	
	public static Color getColor(int index) {
		return colors[(index % colors.length)];
	}
}
