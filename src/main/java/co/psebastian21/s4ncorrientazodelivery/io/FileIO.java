package co.psebastian21.s4ncorrientazodelivery.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	
	public List<String> readFileLines(String path) throws IOException{
		try (BufferedReader reader = this.instantiateBufferedReader(path)){
			String line = reader.readLine();
			List<String> lines = new ArrayList<>();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			return lines;
		}
	}
	public void writeFile(String path, String textToWrite) throws IOException {
		File outputFile = this.instantiateFile(path);
		if(!outputFile.exists()) {
			outputFile.createNewFile();
		}
		try(FileWriter writer = this.instantiateFileWriter(outputFile, false)){
			writer.write(textToWrite);
		}
	}
	BufferedReader instantiateBufferedReader(String path) throws FileNotFoundException {
		return new BufferedReader(new FileReader(path));
	}
	File instantiateFile(String path) {
		return new File(path);
	}
	FileWriter instantiateFileWriter(File file, boolean appendTo) throws IOException {
		return new FileWriter(file, appendTo);
	}

}
