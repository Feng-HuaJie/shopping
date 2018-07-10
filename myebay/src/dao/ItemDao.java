package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Item;
 
 
public class ItemDao {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
 
    public void buyMore(Item i) {
    	String sql = "insert into orderitem values(null,?,?,?)";

        try {
        	c = DBUtil.getConn();
        	ps = c.prepareStatement(sql);

            ps.setInt(1,i.getProduct().getId());
            ps.setInt(2,i.getNum());
            ps.setInt(3,i.getOrder().getOid());
             
            ps.execute();
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	DBUtil.close(rs, ps, c);
        }
         
    }
 
}