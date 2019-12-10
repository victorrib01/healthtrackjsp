package br.com.fiap.healthtrack.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbManager {

	public static Connection obterConexao() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"system",
					"root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
	
}