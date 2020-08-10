package co.psebastian21.s4ncorrientazodelivery;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import co.psebastian21.s4ncorrientazodelivery.droneoperation.Drone;
import co.psebastian21.s4ncorrientazodelivery.io.FileIO;

public class DeliverySystemTests {
	@Test
	public void whenWorkingThenDronesDeliver() throws IOException {
		//Arrange
		List<String> instructions = Arrays.asList("AAA");
		FileIO fileIO = Mockito.mock(FileIO.class);
		Mockito.when(fileIO.readFileLines(Mockito.anyString())).thenReturn(instructions);
		DeliverySystem system = new DeliverySystem();
		system.setFileIO(fileIO);
		Drone drone = Mockito.mock(Drone.class);
		Mockito.when(drone.deliver()).thenReturn("");
		List<Drone> drones = Arrays.asList(drone);
		system.init();
		system.setDrones(drones);
		//Act
		system.work();
		//Assert
		Mockito.verify(drone).deliver();
	}
	@Test(expected = IllegalStateException.class)
	public void whenNotInitializedThenThrowException() throws IOException {
		//Arrange
		DeliverySystem system = new DeliverySystem();
		//Act
		system.work();
	}
	@Test
	public void whenMaxCargoLimitExceededThenThrowException() throws IOException {
		//Arrange
		List<String> instructions = Arrays.asList("AAA", "AAA", "AAA", "AAA");
		FileIO fileIO = Mockito.mock(FileIO.class);
		Mockito.when(fileIO.readFileLines(Mockito.anyString())).thenReturn(instructions);
		DeliverySystem system = new DeliverySystem();
		system.setFileIO(fileIO);
		//Act
		system.init();
		//Assert
		Mockito.verify(fileIO, Mockito.times(20)).writeFile(Mockito.anyString(), Mockito.anyString());
	}
}
