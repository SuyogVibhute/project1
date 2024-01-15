package data;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class Day7Statement {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Movie","root","Root@123");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Ticketid: ");
		int tid=sc.nextInt();
		
		System.out.println("Enter the Name: ");
		String nm = sc.next();
		
		System.out.println("Enter the MovieName: ");
		String mnm = sc.next();
		
		System.out.println("Enter the price: ");
		int pr = sc.nextInt();
		
		String insertData = "insert into moviefun values("+tid+",'"+nm+"','"+mnm+"',"+pr+")";
		 
		System.out.println("Update Movie name and price: ");
		String mnm1= sc.next();
		int pr1= sc.nextInt();
		int tid1= sc.nextInt();
		String updateData ="update moviefun set Moviename='"+mnm1+"',TicketPrice= "+pr1+" where Ticketid="+tid1;
		
		System.out.println("Insert the Ticketid which you want to delete from the table: ");
		int tid2= sc.nextInt();
		String deleteData= "delete from moviefun where Ticketid ="+tid2;
		
		String retriveAll = "select * from moviefun";
		
		Statement smt = con.createStatement();
		smt.execute(insertData);
		smt.execute(updateData);
		smt.execute(deleteData);
		smt.execute(retriveAll);
		
		ResultSet rs = smt.executeQuery(retriveAll);
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println("______________");
		}
		
		rs.close();
		smt.close();
		con.close();
		
		System.out.println("Data Inserted....");
	}

}
