package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil { // Factory class

	
//	FileReader filereader=new FileReader("resources/database.properties");
	public static Connection   getDBConnection() { // Factory method 
		
		Connection conn = null;
		
		try {
			FileReader filereader=new FileReader("resources/database.properties");
			Properties properties=new Properties();
			properties.load(filereader);
			//step1
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2

		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware_db", "root", "root");

		}
		 catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return conn;
		
	}
	
	
}
