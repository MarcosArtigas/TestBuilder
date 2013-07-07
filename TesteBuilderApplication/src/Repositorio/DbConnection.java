package Repositorio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alexsandro
 */
public class DbConnection {
    private static Connection conexao;
    	private DbConnection () {
		try {
			// The newInstance() call is a work around for some // broken Java
			// implementations
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_testbuilder","root", "admin");
		} catch (Exception e) {
			System.out.println("Não foi possível encontrar o driver.");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if(conexao == null) {
			new DbConnection();
		}
		return conexao;
	}

	public static void releseadConnection() {
		conexao = null;
	}
}