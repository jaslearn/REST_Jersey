package com.revature.rest.emp.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {
private static Connection conn=null;



public static Connection getConnection() {
	 Properties p=new Properties(); 
	try {
		//FileReader reader = new FileReader("src/main/resources/db.properties");
	//	p.load(reader);
		p.load(ConnectionUtils.class.getResourceAsStream("/db.properties"));
		String URL=p.getProperty("db.url");
		String port=p.getProperty("db.port");
		String db=p.getProperty("db.database");
		String user=p.getProperty("db.user");
		String pwd=p.getProperty("db.password");
		//"jdbc:postgresql://database-1.cyxwbmqwxsuz.us-east-2.rds.amazonaws.com/dvdrental";
		Class.forName("org.postgresql.Driver");
		String DBURL="jdbc:postgresql://"+URL+":"+port+"/"+db;
		conn=DriverManager.getConnection(DBURL,user,pwd);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return conn;
}

}
