package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Product;
 
public class ProductDao {
	
	Product pd = null;
	Connection c = null;
	PreparedStatement ps = null;
	List<Product> pds = null;
	ResultSet rs = null;
 
    public Product getProductById(int id) {
        String sql = "select * from product where id = ?";

        try {
            c = DBUtil.getConn();
        	ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                pd = new Product();
                pd.setId(id);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                pd.setName(name);
                pd.setPrice(price);
 
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	DBUtil.close(rs, ps, c);
        }
        return pd;
    }
 
    public List<Product> ListProduct() {
        pds = new ArrayList<Product>();
        String sql = "select * from product order by id desc";
        
        try {
        	c = DBUtil.getConn();
        	ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
 
                pd.setId(id);
                pd.setName(name);
                pd.setPrice(price);
                pds.add(product);
 
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	DBUtil.close(rs, ps, c);
        }
        return pds;
    }
}