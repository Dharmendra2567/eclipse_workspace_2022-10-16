package jdbc.insert;

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
	String sql="insert into product(name,manufacturer,description,price,inStock) values(?,?,?,?,?)";
	Connection con = DriverManager.getConnection(url,usr,pwd);
	PreparedStatement pstm = con.prepareStatement(sql);
	Product p = getProductDetails();
	pstm.setString(1, p.getName());
	pstm.setString(2,p.getManufacturer());
	pstm.setString(3, p.getDescription());
	pstm.setFloat(4, p.getPrice());
	pstm.setBoolean(5,p.isInStock());
	pstm.executeUpdate();
	
	
//	ArrayList<Product> person = new ArrayList<>();
//	person.addAll((Collection<? extends Product>) stm.executeQuery(sql));
//	System.out.println(person);
	
			
	pstm.close();
	con.close();
}

private static Product getProductDetails() {
	Product product = new Product();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the product name");
	product.setName(sc.nextLine());
	System.out.println("Enter manufacturer name");
	product.setManufacturer(sc.nextLine());
	System.out.println("Enter description");
	product.setDescription(sc.nextLine());
	System.out.println("Enter price");
	product.setPrice(sc.nextFloat());
	System.out.println("is in stock?(y/n)");
	product.setInStock(sc.next().equalsIgnoreCase("y")?true:false);
	return product;
}
}
