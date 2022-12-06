package jdbcDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.insert.Product;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		char ch;
		Scanner sc = new Scanner(System.in);
		ProductDao pDao = new ProductDao();
		do {
			do {
		System.out.println("Enter");
		System.out.println("a. for insert data");
		System.out.println("b.for view a data");
		System.out.println("c for view all data");
		System.out.println("d. for update data");
		System.out.println("e. for delete data");
		ch=sc.next().charAt(0);
			}while(!(ch=='a'||ch=='b'||ch=='c'||ch=='d'||ch=='e'));
		if(ch=='a') {
		Product p = getProductDetails();
		int j = pDao.save(p);
		if(j==1) {
			System.out.println("data inserted to the database");
		}
		else {
			System.out.println("data not inserted to the database");
		}
		}
		else if(ch=='b') {
			System.out.println("Enter the product id to be viewed");
			int id=sc.nextInt();
			System.out.println( pDao.getOne(id));
		}
		else if(ch=='c') {
			ArrayList<Product> products = new ArrayList<>();
			products =pDao.getAll();
			for(Product p:products) {
			System.out.println(p);
			}
		}
		else if(ch=='d') {
			System.out.println("Enter the product id to be updated");
			int id =sc.nextInt();
			Product p = pDao.getOne(id);
			System.out.println(p);
			do {
			System.out.println("Do you want to update(y/n)");
			ch=sc.next().charAt(0);
			if(ch=='y') {
				Product pd= getProductDetails();
				pd.id=p.getId();
				int i = pDao.update(pd);
				if(i==1) {
					System.out.println("data updated successfully");
				}
				else {
					System.out.println("updation failed");
				}
			}
			}while(ch=='y');
			}
		else if(ch=='e') {
			System.out.println("Enter the product id to be deleted");
			int id =sc.nextInt();
			Product p = new Product();
			p=pDao.getOne(id);
			System.out.println(p);
			do {
			System.out.println("Do you want to delete(y/n)");
			ch=sc.next().charAt(0);
			}while(!(ch=='y'||ch=='n'));
				int i =pDao.delete(id);
				if(i==1) {
					System.out.println("product deleted successfully");
				}
				else {
					System.out.println("deletion failed");
				}
			}
		else {
			System.out.println("invalid input");
		}
		do {
		System.out.println("Do you want to continue(y/n)");
		ch=sc.next().charAt(0);
		}while(!(ch=='y'||ch=='n'));
		}while(ch=='y');
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
