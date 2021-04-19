package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {
	
	static private final String jdbcURL="jdbc:mysql://localhost/dizionario?user=root&password=root1";
	
	static private HikariDataSource ds=null;

	public static Connection getConnection(){
		
		if(ds==null) {
			ds=new HikariDataSource();
			
			ds.setJdbcUrl(jdbcURL);
		//	ds.setUsername("root");   li ho gia indicati sopra
		//	ds.setPassword("root1");
		}
		
		try {
			Connection connection= ds.getConnection();
			return connection;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcURL, e);
		}
		
	}
}
