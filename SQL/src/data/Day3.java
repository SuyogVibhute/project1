package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Root@123");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.Insert Data \n2.Update data");
		System.out.println("Enter yoour choice:");
		int ch = sc.nextInt();
		
		Statement smt = con.createStatement();
		
		if(ch==1)
		{
		System.out.println("Enter your id Here ");
		int id =sc.nextInt();
		
		System.out.println("Enter your name Here ");
		String nm  =sc.next();
		
		System.out.println("Enter your city Here ");
		String cy =sc.next();
		
		System.out.println("Enter your marks Here: ");
		int mk=sc.nextInt();
		
		String insertData="insert into student values("+id+",'"+nm+"','"+cy+"',"+mk+")";
		
		smt.execute(insertData);
		}
		
		else if(ch==2)
		{
		System.out.println("Update name, city And marks in the database: ");
		String empnm=sc.next();
		String city=sc.next();
		int marks=sc.nextInt();
		int empid1=sc.nextInt();
		
		String updateData = "update student set name='"+empnm+"' ,city= '"+city +"' ,marks="+marks+" where id=" + empid1;
		smt.execute(updateData);
		}
		else 
		{
			System.out.println("invalid input.....");
		}
		
		
		System.out.println("insert id which you want to delete from the database: ");
		int empid=sc.nextInt();
		String deleteData ="delete from student where id="+empid;
		
		
		
		
		smt.execute(deleteData);
		
		smt.close();
		con.close();
		
		System.out.println("Data Manipulated.....");
	}

}
