package dao;

import java.sql.*;

import ConnectionManager.ConnectionManager;
import model.login;

public class loginDAO {
	public boolean checkCredential(login l) throws ClassNotFoundException, SQLException
	{
		//1.get the details from login.java file
		String username = l.getUsername();
		String password= l.getPassword_deatails();
        // 2.jdbc connection
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.establishConnection();
		//3.create the statement
		Statement  st = con.createStatement();
		//4.write and execute the query
		ResultSet rt = st.executeQuery("select * from login");
		//5.check username and password
		while(rt.next())
		{
			if(username.equals(rt.getString("username"))&& password.equals(rt.getString("password_details")))
			{
				cm.closeConnection();
				return true;
			}
		}
		cm.closeConnection();
		return false;
	}

}

