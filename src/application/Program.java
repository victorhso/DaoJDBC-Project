package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);

		SellerDAO sellerDao = DaoFactory.createSellerDao();  
		
		System.out.println("===Teste 1: seller findById===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===Teste 2: seller findByDepartment==");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===Teste 3: seller findAll==");
		dep = new Department(2, null);
		list = sellerDao.findAll();
		
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===Teste 4: seller Insert==");		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep); 
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New ID = " + newSeller.getId());
		
		System.out.println("\n===Teste 5: seller Update==");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n===Teste 6: seller delete==");
		System.out.print("Digite um para teste de deleta��o: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completo!");
		sc.close();
	}
}
