package collableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Day2OutParameter {

	public static void main(String[] args) throws Exception {
	    Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedata","root","Root@123");
		
		CallableStatement cs =con.prepareCall("{call Addition(?,?,?,?,?,?)}");
		// for Setting value for a and b
		cs.setInt(1, 28);
		cs.setInt(2, 52);
		
		
		cs.registerOutParameter(3, Types.INTEGER);
		cs.registerOutParameter(4, Types.INTEGER);
		cs.registerOutParameter(5, Types.INTEGER);
		cs.registerOutParameter(6, Types.INTEGER);
		
		
		
		cs.execute();
		System.out.println("Addition is: "+cs.getInt(3));
		System.out.println("Substraction is: "+cs.getInt(4));
		System.out.println("Multiplication is: "+cs.getInt(5));
		System.out.println("Division is: "+cs.getInt(6));
		
		
		cs.close();
		
		con.close();
		

	}

}
