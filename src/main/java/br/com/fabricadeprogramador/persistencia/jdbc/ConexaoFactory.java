package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","06122014");
		} catch (SQLException e) {
			System.out.println("Não Conectou:  " + e.getMessage());
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Não Conectou:  " + e.getMessage());
			return null;
		}
	}

	
	
	
}
