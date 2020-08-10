package co.psebastian21.s4ncorrientazodelivery.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;

public class FileIOTests {
	@Test
	public void whenReadingFileThenFileLinesAreReturned() throws IOException {
		//Arrange
		FileIO fileIO = Mockito.spy(new FileIO());
		BufferedReader reader = Mockito.mock(BufferedReader.class);
		Mockito.doReturn(reader).when(fileIO).instantiateBufferedReader(Mockito.anyString());
		Mockito.when(reader.readLine()).thenReturn("AAA").thenReturn("DID").thenReturn(null);
		Mockito.doNothing().when(reader).close();
		List<String> expected = Arrays.asList("AAA", "DID");
		//Act
		List<String> output = fileIO.readFileLines("");
		//Assert
		Assert.assertEquals(expected, output);
	}

}
