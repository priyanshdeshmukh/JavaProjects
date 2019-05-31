package main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {
	public static void main(String args[]){  
		java.sql.Connection connection = null;
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test","root", "root");  
		Statement stmt = connection.createStatement();  
		ResultSet rs = stmt.executeQuery("select * from customers");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDate(4));  
		connection.close();  
		}catch(Exception e){ System.out.println(e);}  
		}  
}
