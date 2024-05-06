import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.Persistence;

public class TesteConexao {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("meu-primeiro-projeto");
		
	}

}
