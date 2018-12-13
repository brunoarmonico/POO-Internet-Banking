package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;  


//Conexão com o SQL Server
public class DBUtil {
	private static DBUtil instancia;
	private Connection conexao;
	
	private DBUtil() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conexao = DriverManager.getConnection("LINK REMOVIDO");
			System.out.println("Logado no Azure");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		if (instancia == null) {
			instancia = new DBUtil();
		}
		return instancia;
	}

	public Connection getConnection() {
		return conexao;
	}
}
