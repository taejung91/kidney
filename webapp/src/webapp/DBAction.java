package webapp;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBAction {
	private static DBAction instance = new DBAction();
	private Connection conn;
	private DataSource ds;

	public DBAction() {
		/*
		 * String driver = "com.mysql.cj.jdbc.Driver"; String url =
		 * "jdbc:mysql://localhost:3306/app?characterEncoding=UTF-8&serverTimezone=UTC";
		 * 
		 * try { Class.forName(driver); conn = ㄴDriverManager.getConnection(url, "root",
		 * "java"); }catch(Exception e) { e.printStackTrace(); }
		 * 
		 * }
		 */
                  // DBCP 각 사이트에서 제공하기때문에 사이트에서 다운받을 수 있음.
		try {
			InitialContext initctx = new InitialContext();
			ds = (DataSource) initctx.lookup("java:/comp/env/jdbc/oracle"); // 이름으로 찾아서 쓴다 lookup. 고정 자바 환경 주소: java:/comp/env
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	

	public Connection getConnection() {
		try {
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	public static DBAction getInstance() {
		if (instance == null)
			instance = new DBAction();
		return instance;
	}

	/*
	 * public Connection getConnection() { return conn; }
	 */
	public void close() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
