package readAndWriteData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingFromTextFile {

	public static void main(String[] args) throws IOException {
		
		String bufferedFileWriterlocation = "./test-data-files/Buffered File Writer.txt";
		
		FileReader readFileFromTextFile = new FileReader(bufferedFileWriterlocation);
		
		BufferedReader readFileUisngBufferedReader = new BufferedReader(readFileFromTextFile);
		
		String contentToRead;
		while((contentToRead = readFileUisngBufferedReader.readLine())!=null) {
		
		System.out.println(contentToRead);
		
		}
		readFileUisngBufferedReader.close();

	}

}
