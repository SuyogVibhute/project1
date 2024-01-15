package data;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class Day6PreparedStatement {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Root@123");
		
		String insertData = "insert into student values(?,?,?,?)";
		
		String retriveAll = "select * from student where id=3";
		
		Statement smt = con.createStatement();
		 
		PreparedStatement ps = con.prepareStatement(insertData);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student id: ");
		int id = sc.nextInt();
		
		System.out.println("Enter Student Name: ");
		String name= sc.next();
		
		System.out.println("Enter Student City:");
		String city= sc.next();
		
		System.out.println("Enter Student Marks: ");
		int marks= sc.nextInt();
		
		ResultSet rs = smt.executeQuery(retriveAll);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println("___________________");
		}
		
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, city);
		ps.setInt(4, marks);
		
		ps.execute();
		rs.close();
		ps.close();
		con.close();
		
		System.out.println("Value Inserted.....");
				
	}

}
