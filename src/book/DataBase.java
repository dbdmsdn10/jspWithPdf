package book;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public static Connection CON;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			CON = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb?characterEncoding=UTF-8&serverTimezone=UTC", "root","9009908dms");
		} catch (Exception e) {
			System.out.println("접속실패:" + e.toString());
		}
	}
}