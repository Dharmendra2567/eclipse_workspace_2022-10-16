package jdbcDAO;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.insert.Product;

public class ProductDao extends AbstractDao<Product> {
	PreparedStatement pstm;
	ResultSet rs;
	
	public ProductDao() {
		super();
		super.driver="com.mysql.cj.jdbc.Driver";
	}
	@Override
	public int save(Product product) throws ClassNotFoundException, SQLException {
		connect();
		String sql="insert into product(name,manufacturer,description,price,inStock) values(?,?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, product.getName());
		pstm.setString(2,product.getManufacturer());
		pstm.setString(3, product.getDescription());
		pstm.setFloat(4, product.getPrice());
		pstm.setBoolean(5,product.isInStock());
		int i = pstm.executeUpdate();
		disconnect();
		return i;
	}
	@Override
	public Product getOne(int id) throws ClassNotFoundException, SQLException {
		connect();
		String sql="select *from product where id=?";
		pstm=con.prepareStatement(sql);
		Product p = new Product();
		pstm.setInt(1, id);
		rs= pstm.executeQuery();
		if(rs.next()) {
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setManufacturer(rs.getString("manufacturer"));
		p.setDescription(rs.getString("description"));
		p.setPrice(rs.getLong("price"));
		p.setInStock(rs.getBoolean("inStock"));
		}
		disconnect();
		return p;
	}

	@Override
	public ArrayList<Product> getAll() throws ClassNotFoundException, SQLException {
		connect();
		String sql = "select *from product";
		ArrayList<Product>products = new ArrayList<>();
		 pstm = con.prepareStatement(sql);
		 ResultSet rs =pstm.executeQuery();
		Product p = new Product();
		while(rs.next()) {
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setManufacturer(rs.getString("manufacturer"));
			p.setDescription(rs.getString("description"));
			p.setPrice(rs.getFloat("price"));
			p.setInStock(rs.getBoolean("inStock"));
			products.add(p);
		}
		disconnect();
		return products;
	}
	@Override
	public int update(Product product) throws ClassNotFoundException, SQLException {
		connect();
		String sql="update product set name=?, manufacturer=?, description=?, price=?,instock=? where id=?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1,product.getName());
		pstm.setString(2,product.getManufacturer());
		pstm.setString(3, product.getDescription());
		pstm.setFloat(4, product.getPrice());
		pstm.setBoolean(5,product.isInStock());
		pstm.setInt(6, product.getId());
		int i = pstm.executeUpdate();
		disconnect();
		return i;
	}
	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		connect();
		String sql="delete from product where id=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, id);
		int i = pstm.executeUpdate();
		disconnect();
		return i;
	}
}
