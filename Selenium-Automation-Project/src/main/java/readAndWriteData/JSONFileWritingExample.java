package readAndWriteData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONFileWritingExample {

	public static void main(String[] args) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Environment", "UAT1");
		jsonObject.put("Account", "846163136");
		jsonObject.put("Amount", 20);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add("John");
		jsonArray.add("David");
		jsonArray.add("Alex");
		
		jsonObject.put("First Name", jsonArray);
		
		FileWriter writer = new FileWriter("./test-data-files/JSON Test File.json");
		
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write(jsonObject.toJSONString());
		bufferedWriter.close();
		
		System.out.println("Program ran succesfully for JSON Writer");
		
		jsonObject.get("Environment");
		System.out.println(jsonObject.get("Environment"));
		
	}

}
