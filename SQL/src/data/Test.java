package data;
import java.sql.*;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedata","root","Root@123");
		System.out.println("connection established");
		
		//String insertData="insert into studentlist values(6,'rutik','c')";
		
		System.out.println("sql query constructed");
		
		Statement smt=con.createStatement();
		System.out.println("reference created");
		
		//smt.execute(insertData);
		
		System.out.println("Query submitted");
		
		
		
		
		String selectData="select * from studentlist";
		ResultSet rs = smt.executeQuery(selectData);
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println("--------");
		}
		
		smt.close();
		con.close();
		System.out.println("All resources closed");
	}

}
