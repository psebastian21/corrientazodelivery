package co.psebastian21.s4ncorrientazodelivery;

import java.io.IOException;
import java.util.List;

import co.psebastian21.s4ncorrientazodelivery.droneoperation.Drone;
import co.psebastian21.s4ncorrientazodelivery.io.FileIO;

public class DeliverySystem {
	
	private static int maxDrones = 20;
	private static int maxDistance = 10;
	private static int maxCargo = 3;

	private List<Drone> drones;
	private FileIO fileIO;
	private String[] files = {
			"in01.txt",	"in02.txt",	"in03.txt",	"in04.txt",	"in05.txt",	"in06.txt",	"in07.txt",	"in08.txt",
			"in09.txt",	"in10.txt",	"in11.txt",	"in12.txt",	"in13.txt",	"in14.txt",	"in15.txt",	"in16.txt",
			"in17.txt",	"in18.txt",	"in19.txt",	"in20.txt"
	};
	
	public static int getMaxDrones() {
		return maxDrones;
	}
	public static int getMaxDistance() {
		return maxDistance;
	}
	public static void setMaxDistance(int maxDistance) {
		DeliverySystem.maxDistance = maxDistance;
	}
	public static int getMaxCargo() {
		return maxCargo;
	}
	public static void setMaxCargo(int maxCargo) {
		DeliverySystem.maxCargo = maxCargo;
	}
	
	public DeliverySystem() throws IOException {
		for(int i = 0; i < DeliverySystem.maxDrones; i++) {
			List<String> instructions = fileIO.readFileLines(files[i]);
			Drone drone = new Drone(instructions);
			drones.add(drone);
		}
	}
	
	public void work() {
		drones.parallelStream()
		.forEach(Drone::deliver);
	}

}
