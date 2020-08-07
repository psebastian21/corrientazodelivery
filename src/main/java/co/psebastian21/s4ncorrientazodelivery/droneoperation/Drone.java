package co.psebastian21.s4ncorrientazodelivery.droneoperation;

import java.util.List;

import co.psebastian21.s4ncorrientazodelivery.droneoperation.exception.MaxCargoLimitExceededException;
import co.psebastian21.s4ncorrientazodelivery.droneoperation.exception.MaxDistanceLimitExceededException;

public class Drone {
	private static int maxDistance = 10;
	private static int maxCargo = 3;
	
	private List<String> instructions;
	private SpatialSituation locationAndHeading;
	
	public Drone (List<String> instructions) {
		if(instructions.size() > Drone.maxCargo) {
			throw new MaxCargoLimitExceededException("Max cargo limit exceeded");
		}
		this.instructions = instructions;
		this.locationAndHeading = new SpatialSituation();
	}
	
	public String deliver() {
		StringBuilder sb = new StringBuilder();
		try {
			instructions.stream().forEach(i -> {
			sb.append(this.execute(i));
			sb.append("\n");
			});
		}
		catch(MaxDistanceLimitExceededException e) {
			sb.append(e.getMessage());
		}
		finally {
			this.getHome();
		}
		return sb.toString();
	}
	
	private void moveForward() {
		Point finalLocation = this.locationAndHeading.moveForward();
		double distanceFromOrigin = Math.sqrt(Math.pow(finalLocation.getX(), 2) + Math.pow(finalLocation.getY(), 2));
		if(distanceFromOrigin > Drone.maxDistance) {
			throw new MaxDistanceLimitExceededException("Max distance limit exceeded");
		}
	}
	private HeadingValue rotateClockwise() {
		return this.locationAndHeading.rotateClockwise();
	}
	private HeadingValue rotateCounterclockwise() {
		return this.locationAndHeading.rotateCounterclockwise();
	}
	private String execute(String instruction) {
		
	}
	private void getHome() {
		// TODO Auto-generated method stub
		
	}
}
