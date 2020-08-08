package co.psebastian21.s4ncorrientazodelivery.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	
	public List<String> readFileLines(String path) throws IOException{
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
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
		File outputFile = new File(path);
		if(!outputFile.exists()) {
			outputFile.createNewFile();
		}
		try(FileWriter writer = new FileWriter(outputFile, false)){
			writer.write(textToWrite);
		}
	}

}
