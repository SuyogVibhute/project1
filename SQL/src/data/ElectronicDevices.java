package data;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class ElectronicDevices {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Root@123");
	
        Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter the Product id: ");
	    int id = sc.nextInt();
	    
	    System.out.println("Enter the Product Name: ");
	    String nm = sc.next();
	    
	    System.out.println("Enter the Price: ");
	    int pc = sc.nextInt();
	    
	    System.out.println("Enter the Category: ");
	    String cat = sc.next();
	    
	    System.out.println("Enter the Quantity: ");
	    int qt = sc.nextInt();
	    
	    String insertdata ="insert into electronicdevice values("+id+",'"+nm+"',"+pc+",'"+cat+"',"+qt+")";
	    System.out.println("Update Product name And price in the database: ");
	    String pnm=sc.next();
		int pc1=sc.nextInt();
	    int id1=sc.nextInt();
		String updateData = "update electronicdevice set Product_name='"+pnm+"' ,price=" + pc1 + " where id=" +id1;
	
		System.out.println("insert id which you want to delete from the database: ");		
		int pid2=sc.nextInt();
	    String deleteData ="delete from electronicdevice where Product_id="+pid2;
	    
		String RetriveAll= "select * from electronicdevice";

		
		Statement smt = con.createStatement();
		smt.execute(insertdata);
		smt.execute(updateData);
		smt.execute(deleteData);
		smt.execute(RetriveAll);
		
	    
	    
	    ResultSet rs = smt.executeQuery(RetriveAll);
	    
	    while(rs.next()) 
	    {
	    	System.out.println(rs.getInt(1));
	    	System.out.println(rs.getString(2));
	    	System.out.println(rs.getInt(3));
	    	System.out.println(rs.getString(4));
	    	System.out.println(rs.getInt(5));
	    	System.out.println("_________________");
	    }
	    
		
	    
	    rs.close();
	    smt.close();
	    con.close();
	    
	}

}
