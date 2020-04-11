package teacher;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static Connection conn = null;

	public static Connection open() {

		String url = "jdbc:oracle:thin:@211.63.89.41:1521:xe";
		String id = "DB5";
		String pw = "1234";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, id, pw);

			return conn;

		} catch (Exception e) {
			System.out.println("DBUtil.open()");
			e.printStackTrace();
			// TODO: handle exception
		}

		return null;
	}
}
