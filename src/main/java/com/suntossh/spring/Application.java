package com.suntossh.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Application {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "spring", "password");
			preparedStatement = connection.prepareStatement("insert into RENTAL_LOCATION values (?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "Gas Station");
			preparedStatement.setString(3, "Add 11");
			preparedStatement.setString(4, "Add 22");
			preparedStatement.setString(5, "City");
			preparedStatement.setString(6, "State");
			preparedStatement.setString(7, "Postal Code");
			
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
