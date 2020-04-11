package main;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	private static Connection conn = null;

	//오라클 접속 > Connection 객체 생성 + 반환
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
		}
		
		return null;
		
	}
	
	public static Connection open(String server, String id, String pw) {
		
		String url = "jdbc:oracle:thin:@" + server + ":1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			return conn;
			
		} catch (Exception e) {
			System.out.println("DBUtil.open()");
		}
		
		return null;
		
	}
	
	public static void close() {
		
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}
