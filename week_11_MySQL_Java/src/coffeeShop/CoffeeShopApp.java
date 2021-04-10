package coffeeShop;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import coffeeShop.dao.CoffeeShopDAO;
import coffeeShop.entity.CoffeeShop;

public class CoffeeShopApp {

	private Scanner scanner = new Scanner(System.in);
	private CoffeeShopDAO coffeeshopDAO = new CoffeeShopDAO();

	public static void main(String[] args) throws SQLException {
		new CoffeeShopApp().run();
	}

	/**
	 * 
	 */
	private void run() throws SQLException {
		while(true) {
			printInstruction();
			
			System.out.println("Enter a Selection:");
			String choice = scanner.nextLine();
			
			try {
			if (choice.isBlank()) {
				break;
			}
			switch (choice) {
			 case "1":
				 createCoffeeShop();
				 break;
			 
			 case "2" :
				 modifyCoffeeShop();
				 break;
				 
			 case "3":
				 listCoffeeShop();
				 break;
			
			 case "4":
				 deleteCoffeeShop();
				 break;
			default:
				System.out.println("Invalid Choice. Try again!");
			}
			}
			catch(Exception e) {
			System.out.println("Stop! You have an error: " + e.getMessage());
			break;
	  }	
	 }
	}

	private void deleteCoffeeShop() throws SQLException {
		listCoffeeShop();
		System.out.print("Enter the CoffeeShop ID to delete:");
		long id = Long.parseLong(scanner.nextLine());
		
		coffeeshopDAO.deleteCoffeeShop(id);
		listCoffeeShop();
		
	}

	private void modifyCoffeeShop() throws SQLException {
		listCoffeeShop();
		System.out.print("Enter the CoffeeShop ID to modify:");
		long id = Long.parseLong(scanner.nextLine());
		
		System.out.println("Enter the new CoffeeShop name:");
		String name = scanner.nextLine();
		
		coffeeshopDAO.modifyCoffeeShop(name, id);
		listCoffeeShop();
		
	}

	private void listCoffeeShop() throws SQLException {
		List<CoffeeShop> coffeeShop = coffeeshopDAO.fetchCoffeeShop();
		coffeeShop.stream().forEach(System.out:: println);
	}

	private void createCoffeeShop() throws SQLException {
	System.out.print("Enter New CoffeeShop Name: ");
	String name = scanner.nextLine();
	coffeeshopDAO.createCoffeeShop(name);
	
	}
		

	private void printInstruction() {
		System.out.println("Select an Option:");
		System.out.println("1: Create a CoffeeShop");
		System.out.println("2: Modify a CoffeeShop");
		System.out.println("3: List a CoffeeShop");
		System.out.println("4: Delete a CoffeeShop");
		
	}

}
