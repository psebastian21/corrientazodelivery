package co.psebastian21.s4ncorrientazodelivery.droneoperation;

import java.io.IOException;
import java.util.List;

import co.psebastian21.s4ncorrientazodelivery.DeliverySystem;
import co.psebastian21.s4ncorrientazodelivery.droneoperation.exception.MaxCargoLimitExceededException;
import co.psebastian21.s4ncorrientazodelivery.droneoperation.exception.MaxDistanceLimitExceededException;
import co.psebastian21.s4ncorrientazodelivery.io.FileIO;

public class Drone {
	
	private List<String> instructions;
	private SpatialSituation locationAndHeading;
	private int droneNumber;
	
	public Drone (List<String> instructions, int droneNumber) {
		if(instructions.size() > DeliverySystem.getMaxCargo()) {
			//TODO output as text file
			throw new MaxCargoLimitExceededException("Max cargo limit exceeded");
		}
		this.instructions = instructions;
		this.locationAndHeading = new SpatialSituation();
		this.droneNumber = droneNumber;
	}
	
	public String deliver() throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			instructions.stream().forEach(i -> {
			sb.append(this.executeOneInstruction(i));
			sb.append("\n");
			});
		}
		catch(MaxDistanceLimitExceededException e) {
			sb.append(e.getMessage());
		}
		finally {
			this.getHome();
			FileIO fileIO = new FileIO();
			String fileName = this.droneNumber <= 9 ? "out0" + this.droneNumber + ".txt" : "out" + this.droneNumber + ".txt";
			fileIO.writeFile(fileName, sb.toString());
		}
		return sb.toString();
	}
	
	private void moveForward() {
		Point finalLocation = this.locationAndHeading.moveForward();
		double distanceFromOrigin = Math.sqrt(Math.pow(finalLocation.getX(), 2) + Math.pow(finalLocation.getY(), 2));
		if(distanceFromOrigin > DeliverySystem.getMaxDistance()) {
			throw new MaxDistanceLimitExceededException("Max distance limit exceeded");
		}
	}
	private HeadingValue rotateClockwise() {
		return this.locationAndHeading.rotateClockwise();
	}
	private HeadingValue rotateCounterclockwise() {
		return this.locationAndHeading.rotateCounterclockwise();
	}
	private String executeOneInstruction(String instruction) {
		for(int i = 0; i < instruction.length(); i++) {
			char c = instruction.charAt(i);
			switch(c) {
			case 'A':
				this.moveForward();
				break;
			case 'I':
				this.rotateCounterclockwise();
				break;
			default:
				this.rotateClockwise();
			}
		}
		Point currentLocation = this.locationAndHeading.getLocation();
		StringBuilder sb = new StringBuilder();
		sb.append('(')
		.append(String.valueOf(currentLocation.getX()))
		.append(", ")
		.append(String.valueOf(currentLocation.getY()))
		.append(") direction ")
		.append(this.locationAndHeading.getHeading());
		return sb.toString();
		
	}
	private void getHome() {
		this.locationAndHeading.getHome();
	}
}
