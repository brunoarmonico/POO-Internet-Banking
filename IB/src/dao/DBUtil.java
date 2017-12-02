package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;  

public class DBUtil {
//	private final static String USERNAME = "(local)";
//	private final static String PASSWORD = "";
//	private final static String URLDB = "jdbc:sqlserver://localhost:20000";
	private static DBUtil instancia;
	private Connection con;

	private DBUtil() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BancoHUE;user=local;password=123456");

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
		return con;
	}
}
