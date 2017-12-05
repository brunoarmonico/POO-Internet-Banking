package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;  

public class DBUtil {
	private static DBUtil instancia;
	private Connection con;

	private DBUtil() {
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			con = DriverManager.getConnection("jdbc:sqlserver://hueinternetbanking.database.windows.net;database=BancoHUE;user=teste;password=Ib12345!");
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:jtds:sqlserver://hueinternetbanking.database.windows.net:1433;DatabaseName=BancoHUE;namedPipes=true;user=teste;password=Ib12345!");
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
		return con;
	}
}
