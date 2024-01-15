package data;

import java.sql.*;
import java.sql.DriverManager;

public class Day5 {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeData","root","Root@123");

		String retriveAll="select * from studentlist";
		
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery(retriveAll);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println("_______________");
		}
		rs.close();
		smt.close();
		con.close();
		
	}

}
