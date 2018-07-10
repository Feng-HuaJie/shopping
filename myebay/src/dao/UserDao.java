package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;

public class UserDao {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	User _user = null;
		
	public User getUser(String name, String password) {
		
		String sql = "select * from user where name = ? and password = ?";
        

		try {
			c = DBUtil.getConn();
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				_user = new User();
				_user.setUid(rs.getInt(1));
				_user.setPassword(password);
				_user.setUname(name);
			}

			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return _user;
	}
}
