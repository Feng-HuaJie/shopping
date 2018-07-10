package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Order;
 
 
public class OrderDao {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
 
    public void addOrder(Order o) {
    	String sql = "insert into order_ values(null,?)";

        try {
	        c = DBUtil.getConn();
	        ps = c.prepareStatement(sql);

            ps.setInt(1, o.getUser().getUid());
            ps.execute();
 
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                o.setOid(id);
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	DBUtil.close(rs, ps, c);
        }
 
    }
 
}