package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.customerDetails;

public class connectToMySQL 
{
	public List<customerDetails> makeConnection() throws ClassNotFoundException, SQLException
	{
		List<customerDetails> l = new ArrayList<customerDetails>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "root");
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
		
		while(rs.next())
		{
			customerDetails c = new customerDetails();
			c.setCourseName(rs.getString(1));
			c.setPurchasedDate(rs.getString(2));
			c.setAmount(rs.getInt(3));
			c.setLocation(rs.getString(4));
			l.add(c);
		}
		
		return l;
		
	}
	
	
}
