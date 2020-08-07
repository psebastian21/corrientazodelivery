package co.psebastian21.s4ncorrientazodelivery;

import java.util.List;

public class Drone {
	private static int MAX_DISTANCE = 10;
	
	private List<String> instructions;
	private Point location;
	
	public Drone (List<String> instructions) {
		this.instructions = instructions;
		this.location = new Point();
	}
}
