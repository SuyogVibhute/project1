package data;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root@123");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id Here ");
		int id =sc.nextInt();		
		System.out.println("Enter your name Here ");
		String nm  =sc.next();
		
		System.out.println("Enter your salaray Here ");
		int sl =sc.nextInt();
		
		String insertData="insert into Employeelist values("+id+",'"+nm+"',"+sl+")";

		System.out.println("Update name And salary in the database: ");
		String empnm=sc.next();
		int salary=sc.nextInt();
		int empid1=sc.nextInt();
		String updateData = "update Employeelist set namel='"+empnm+"' ,salary=" + salary + " where id=" + empid1;
		
		System.out.println("insert id which you want to delete from the database: ");
		int empid=sc.nextInt();
		String deleteData ="delete from Employeelist where id="+empid;
		
		Statement smt = con.createStatement();
		smt.execute(insertData);
		smt.execute(updateData);
		smt.execute(deleteData);
		
		smt.close();
		con.close();
		
		System.out.println("Data Manipulated.....");

	}

}
