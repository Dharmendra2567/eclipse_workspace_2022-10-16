package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class App {

	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String driver = "com.mysql.cj.jdbc.Driver";
	Class.forName(driver);
	String url="jdbc:mysql://localhost:3306/mydb";
	String usr ="root";
	String pwd="";
	String sql="delete from product where id=?";
	Connection con = DriverManager.getConnection(url,usr,pwd);
	PreparedStatement pstm = con.prepareStatement(sql);
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the id of product to be deleted");
	pstm.setInt(1, sc.nextInt());
	 pstm.executeUpdate();
	
	pstm.close();
	con.close();
}
}

