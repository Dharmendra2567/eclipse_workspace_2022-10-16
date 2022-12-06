package jdbcDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao<T> implements DataAccessObject<T> {
//	String driver = "com.mysql.cj.jdbc.Driver";
	String driver;
	String url="jdbc:mysql://localhost:3306/mydb";
	String usr ="root";
	String pwd="";
	Connection con;
	

	@Override
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url,usr,pwd);
		
	}

	@Override
	public void disconnect() throws SQLException {
		con.close();
		

	}

	
}
