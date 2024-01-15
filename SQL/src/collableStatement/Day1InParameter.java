package collableStatement;

import java.sql.*;
import java.sql.DriverManager;

public class Day1InParameter {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedata","root","Root@123");
		
		CallableStatement cs =con.prepareCall("{call insertData(?,?,?,?,?)}");
		// for inserting data
		cs.setInt(1, 28);
		cs.setString(2, "imam");
		cs.setString(3, "a");
		
		//for deleting data
		cs.setInt(4,6);
		//for updating data
		cs.setString(5, "Manit");	
		cs.execute();
		
		cs.close();
		//testing github
		con.close();
		System.out.println("Data Updated....");
	}

}
