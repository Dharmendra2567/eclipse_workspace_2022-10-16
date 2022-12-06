package jdbc.getall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class App {

	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String driver = "com.mysql.cj.jdbc.Driver";
	Class.forName(driver);
	String url="jdbc:mysql://localhost:3306/mydb";
	String usr ="root";
	String pwd="";
	Connection con = DriverManager.getConnection(url,usr,pwd);
	String sql="select *from product";
	PreparedStatement pstm = con.prepareStatement(sql);
//	Product p = new Product("RED toothpaste","Dabur","herbal paste",43,true);
	
	ResultSet rs = pstm.executeQuery();
	Product p = new Product();
	while(rs.next()) {
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setManufacturer(rs.getString("manufacturer"));
		p.setDescription(rs.getString("description"));
		p.setPrice(rs.getFloat("price"));
		p.setInStock(rs.getBoolean("inStock"));
		System.out.println(p);
		
	}
	
	
//	ArrayList<Product> person = new ArrayList<>();
//	person.addAll((Collection<? extends Product>) stm.executeQuery(sql));
//	System.out.println(person);
	
			
	pstm.close();
	con.close();
}

}
