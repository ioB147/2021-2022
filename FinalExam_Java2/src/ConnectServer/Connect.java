package ConnectServer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examjava2", "root", "");
		} catch (Exception e) {
			System.out.println("Pheo");
			e.printStackTrace();
		}
		return con;
	}
}
