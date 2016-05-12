package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","06122014");
		} catch (SQLException e) {
			System.out.println("N�o Conectou:  " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	
	
	
}
