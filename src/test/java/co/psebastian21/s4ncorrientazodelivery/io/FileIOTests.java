package co.psebastian21.s4ncorrientazodelivery.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
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
	@Test
	public void whenWritingFileThenFileIsWritten() throws IOException {
		//Arrange
		FileIO fileIO = Mockito.spy(new FileIO());
		File file = Mockito.mock(File.class);
		Mockito.when(file.exists()).thenReturn(true);
		FileWriter writer = Mockito.mock(FileWriter.class);
		Mockito.doNothing().when(writer).write(Mockito.anyString());
		Mockito.doReturn(file).when(fileIO).instantiateFile(Mockito.anyString());
		Mockito.doReturn(writer).when(fileIO).instantiateFileWriter(Mockito.any(File.class), Mockito.anyBoolean());
		//Act
		fileIO.writeFile("", "");
		//Assert
		Mockito.verify(file).exists();
		Mockito.verify(writer).write(Mockito.anyString());
	}
	@Test
	public void whenFileDoesntExistThenCreateAndWrite() throws IOException {
		//Arrange
		FileIO fileIO = Mockito.spy(new FileIO());
		File file = Mockito.mock(File.class);
		Mockito.when(file.exists()).thenReturn(false);
		FileWriter writer = Mockito.mock(FileWriter.class);
		Mockito.doNothing().when(writer).write(Mockito.anyString());
		Mockito.doReturn(file).when(fileIO).instantiateFile(Mockito.anyString());
		Mockito.doReturn(writer).when(fileIO).instantiateFileWriter(Mockito.any(File.class), Mockito.anyBoolean());
		Mockito.when(file.createNewFile()).thenReturn(true);
		//Act
		fileIO.writeFile("", "");
		//Assert
		Mockito.verify(file).exists();
		Mockito.verify(writer).write(Mockito.anyString());
		Mockito.verify(file).createNewFile();
	}

}
