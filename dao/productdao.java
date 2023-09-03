package dao;

import java.sql.*;

import ConnectionManager.ConnectionManager;
import model.product;

public class productdao {
	public void addproduct(product p) throws ClassNotFoundException, SQLException
	{
	 ConnectionManager cm = new ConnectionManager();
	 Connection con = cm.establishConnection();
	 String que = "insert into product(productid ,productname,productprice,productquantity,minsellquantity)values (?,?,?,?,?)";
	 PreparedStatement ps = con.prepareStatement(que);
	 ps.setInt(1, p.getProductid());
	 ps.setString(2,p.getProductname());
	 ps.setInt(3,p.getProductprice());
	 ps.setInt(4,p.getProductquantity());
	 ps.setInt(5, p.getMinsellquantity());
	 ps.executeUpdate();
	 cm.closeConnection();
	}
	public void update(product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.establishConnection();
		String que1 = "update product set productname=?,productprice=?,productquantity=?,minsellquantity=? where productid=?";
		PreparedStatement ps = con.prepareStatement(que1);
		ps.setString(1,p.getProductname());
		ps.setInt(2, p.getProductprice());
		ps.setInt(3,p.getProductquantity());
		ps.setInt(4,p.getMinsellquantity());
		ps.setInt(5,p.getProductid());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void delete(product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.establishConnection();
		String que2 = "delete from product where productid=?";
		PreparedStatement ps = con.prepareStatement(que2);
		ps.setInt(1,p.getProductid());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void display() throws SQLException, ClassNotFoundException
	{
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.establishConnection();
		//3.create the statement
		Statement  st = con.createStatement();
		//4.write and execute the query
		ResultSet rt = st.executeQuery("select * from product");
		//5.check username and password
		while(rt.next())
		{
			System.out.println(rt.getInt("productid")+"|"+rt.getString("productname")+"|"+rt.getInt("productprice")+"|"+rt.getInt("productquantity")+"|"+rt.getInt("minsellquantity"));
		    
		}
		
	}

}
