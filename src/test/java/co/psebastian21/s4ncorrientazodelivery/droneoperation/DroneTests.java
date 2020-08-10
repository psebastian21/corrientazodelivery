package co.psebastian21.s4ncorrientazodelivery.droneoperation;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import co.psebastian21.s4ncorrientazodelivery.io.FileIO;

public class DroneTests {
	@Test
	public void whenExecutingInstructionsThenOutputIsCorrect() throws IOException {
		//Arrange
		FileIO fIO = Mockito.mock(FileIO.class);
		Mockito.doNothing().when(fIO).writeFile(Mockito.anyString(), Mockito.anyString());
		List<String> instructions = new LinkedList<>();
		instructions.add("AAAAIAA");
		instructions.add("DDDAIAD");
		instructions.add("AAIADAD");
		Drone drone = new Drone(instructions, 1);
		drone.setFileIO(fIO);
		//Act
		String output = drone.deliver();
		//Assert
		String expected = "(-2, 4) direction WEST\n" + 
				"(-1, 3) direction SOUTH\n" + 
				"(0, 0) direction WEST\n";
		Assert.assertEquals(expected, output);
	}

}
