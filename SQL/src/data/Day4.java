package data;

import java.sql.*;
import java.sql.DriverManager;

public class Day4 {

	public static void main(String[] args) throws Exception {


		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Root@123");
		
		String retiveAll="select * from student";
		
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery(retiveAll);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println("_____________________");
		}
		rs.close();
		smt.close();
		con.close();
		
				
	}

}
