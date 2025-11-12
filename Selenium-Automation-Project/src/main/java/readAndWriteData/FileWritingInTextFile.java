package readAndWriteData;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingInTextFile {

	public static void main(String[] args) throws IOException {
		
		String fileWriterLocation = "./test-data-files/File Writer.txt";
		String contentForFileWriter = "File Writing success using File Writer!!";
		
		FileWriter writerViaFileWriter = new FileWriter(fileWriterLocation);	
		writerViaFileWriter.write(contentForFileWriter);
		writerViaFileWriter.close();
		
		//---------------------------------------------------------------------------------------//
		
		String bufferedFileWriterlocation = "./test-data-files/Buffered File Writer.txt";
		String contentForBufferedFileWriter = "1. File Writing success using Buffered File Writer!!";
		
		/*
		 * We need to use JRE 15 for Text block
		String contentForBufferedFileWriter = """
													1. File Writing success using Buffered File Writer!!
													2. File Writing success using Buffered File Writer!!
													3. File Writing success using Buffered File Writer!!
													""";
													*/
		
		FileWriter writerViaBufferedFileWriter = new FileWriter(bufferedFileWriterlocation);
		BufferedWriter writerViaBufferedWriter = new BufferedWriter(writerViaBufferedFileWriter);
		
		writerViaBufferedWriter.write(contentForBufferedFileWriter);
		writerViaBufferedWriter.close();
		
		//---------------------------------------------------------------------------------------//
		
		String fileOutputStreamWriterlocation = "./test-data-files/File Output Stream Writer.txt";
		String contentForFileOutputStreamWriter = "File Writing success using File Output Stream Writer!!";
		byte[] contentForFileOutputStreamWriterInByte = contentForFileOutputStreamWriter.getBytes();
		
		FileOutputStream writeViaFileOutputStream = new FileOutputStream(fileOutputStreamWriterlocation);
		
		writeViaFileOutputStream.write(contentForFileOutputStreamWriterInByte);
		writeViaFileOutputStream.close();
		
		System.out.println("File Writing program ran successfuly");

	}

}
