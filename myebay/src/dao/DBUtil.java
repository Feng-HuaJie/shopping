package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static Connection c = null;
	static PreparedStatement ps = null;
	
	public static Connection getConn() {
	try {
		Class.forName("com.mysql.jdbc.Driver");

		c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shoppingcar?characterEncoding=UTF-8",
				"root", "123");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return c;
	}
	
	public static void close(ResultSet rs,Statement s,Connection c) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(s!=null) {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(c!=null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}