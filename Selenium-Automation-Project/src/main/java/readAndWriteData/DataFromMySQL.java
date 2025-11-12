package readAndWriteData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataFromMySQL {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tabledummy", "root", "Dino@17317");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from customer");
		
		while(result.next()) {
			System.out.println("Result is: "+result.getString(2));
		}
	}

}
