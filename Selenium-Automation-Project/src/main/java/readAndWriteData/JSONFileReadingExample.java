package readAndWriteData;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReadingExample {

	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader jsonFile = new FileReader("./test-data-files/JSON Test File.json");
		
		JSONParser parseJSONFile = new JSONParser();
		Object parsedJSONData = parseJSONFile.parse(jsonFile);
		
		JSONObject jsonObject = (JSONObject) parsedJSONData;
		
		String environmentValue = (String)jsonObject.get("Environment");
		String accountValue = (String)jsonObject.get("Account");
		long amountValue = (long)jsonObject.get("Amount");
		
		System.out.println(environmentValue);
		System.out.println(accountValue);
		System.out.println(amountValue);
		
		JSONArray firstNameValues = (JSONArray)jsonObject.get("First Name");
		
		Iterator iterateFirstName = firstNameValues.iterator();
		
		while(iterateFirstName.hasNext()) {
			String fisrtNameValue = (String) iterateFirstName.next();
			System.out.println(fisrtNameValue);
		}
		
		jsonFile.close();

	}

}
